package database;

import javax.persistence.*;

/**
 * Az adatbazisba toltendo elem osztalya.
 */
@Entity
public class ScoreEntity{
    /**
     * Az aktualis eredmeny id-ja.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Az aktualis eredmeny.
     */
    @Column(name = "Score")
    private int score;
    /**
     * Az aktualis jatek futasi ideje.
     */
    @Column(name = "RunTime")
    private float runTime;

    /**
     * Az osztaly konstruktora.
     */
    public ScoreEntity() {
    }

    /**
     * Az osztaly konstruktora.
     * @param score eredmeny
     * @param runTime futasi ido
     */
    public ScoreEntity(int score, float runTime) {
        this.score = score;
        this.runTime = runTime;
    }

    /**
     * Az id lekerese.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Az id beallitasa.
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Az eredmeny lekerese.
     * @return eredmeny
     */
    public int getScore() {
        return score;
    }

    /**
     * Az eredmeny beallitasa.
     * @param score eredmeny
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * A futasi ido lekerese.
     * @return futasi ido
     */
    public float getRunTime() {
        return runTime;
    }

    /**
     * A futasi ido beallitasa.
     * @param runTime futasi ido
     */
    public void setRunTime(float runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "ScoreEntity{" +
                "id=" + id +
                ", score='" + score + '\'' +
                ", runTime='" + runTime + '\'' +
                '}';
    }
}
