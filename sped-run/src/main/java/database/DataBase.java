package database;

import controller.GameEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * Az adatbazis kezelo osztaly.
 */
public class DataBase {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * Az osztaly peldanyositasa.
     */
    private static final DataBase DB_PELDANY = new DataBase();
    /**
     * Az adatbazis neve.
     */
    @PersistenceContext(unitName = "jpa-persistence-unit-1")
    /**
     * EntityManager letrehozasa.
     */
    private EntityManager em;

    /**
     * Private konstruktor.
     */
    private DataBase() {
    }

    /**
     * A DB szingleton példány lekérése.
     * @return singleton példány referencia
     */
    public static DataBase getDbPeldany() {
        return DB_PELDANY;
    }

    /**
     * Az adatbazis kapcsolat letrehozasa.
     * @throws Exception kivetel
     */
    public void connectDB() throws Exception {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emFactory.createEntityManager();
        logger.info("Adatbazis kapcsolat OK");
    }

    /**
     * Az adatbazis kapcsolat lezarasa.
     */
    public void disconnectDB() {
        if (connected()) {
            em.close();
            logger.info("Disconnected");
        }
        em = null;
    }

    /**
     * Letre van e hozva a kapcsolat.
     * @return logikai ertek
     */
    public boolean connected() {

        return em != null && em.isOpen();
    }


    /**
     * Az eredmeny generalasa.
     * @param score eredmenyunk
     * @param runTime jatekido
     */
    public void createScore(int score, float runTime) {
        ScoreEntity scoreEntity = new ScoreEntity(score, runTime);

        em.getTransaction().begin();

        em.persist(scoreEntity);

        em.getTransaction().commit();

        logger.info("Score created");
    }

}