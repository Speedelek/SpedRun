package database;

import javax.persistence.*;
import java.util.List;

public class DataBase {

    /**
     * Osztalyelem peldanyositasa.
     */
    private static final DataBase DB_PELDANY = new DataBase();
    /*
     * Az adatbazis nevet kapja meg
     */
    //private static EntityManagerFactory emFactory;
    /**
     * Az adatbazis neve.
     */
    @PersistenceContext(unitName = "jpa-persistence-unit-1")
    /**
     * EntityManager letrehozasa.
     */
    private EntityManager em;

    /**
     * Privát konstruktor.
     */
    private DataBase() {
    }

    /**
     * Aktiális DB szingleton példány lekérése.
     *
     * @return singleton példány referencia
     */
    public static DataBase getDbPeldany() {
        return DB_PELDANY;
    }

    public void connectDB() throws Exception {
        //persistence.xml-ben fontos, hogy megegyezzen a persistence-unit name ezzel, jelen esetben 'database'
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emFactory.createEntityManager();
        //log.trace("Adatbázis kapcsolat OK.");
    }

    /**
     * Adatbáziskapcsolat lezárása JPA-val.
     */
    public void disconnectDB() {
        if (connected()) {
            em.close();
            //log.trace("Disconnect OK.");
        }
        em = null;
    }

    /**
     * EntityManager él és csatlakoztatva van az adatbázishoz?
     *
     * @return logikai ertek
     */
    public boolean connected() {

        return em != null && em.isOpen();
    }


    /**
     * Az eredmeny generalasa
     * @param score eredmenyunk
     * @param runTime jatekido
     */
    public void createScore(int score, float runTime) {
        ScoreEntity scoreEntity = new ScoreEntity(score, runTime);

        em.getTransaction().begin();

        em.persist(scoreEntity);

        em.getTransaction().commit();
    }

    //elsodleges kulcs szerinti kereses
    public ScoreEntity readScore(int id) {
        return em.find(ScoreEntity.class, id);
    }

    /*private ScoreEntity readScoreByrunTime(float runTime) {
        TypedQuery<ScoreEntity> query = em.createQuery("SELECT s FROM ScoreEntity s WHERE s.neptunID='" + neptunID + "'", Student.class);
        List<Student> result = query.getResultList();

        return result.get(0);
    }*/

     private void deleteStudent(ScoreEntity scoreEntity) {
        em.getTransaction().begin();
        em.remove(scoreEntity);
        em.getTransaction().commit();
    }
}