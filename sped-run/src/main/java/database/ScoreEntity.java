package database;

import javax.persistence.*;

@Entity
public class ScoreEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Score")
    private int score;

    @Column(name = "RunTime")
    private float runTime;

    public ScoreEntity() {
    }

    public ScoreEntity(int score, float runTime) {
        this.score = score;
        this.runTime = runTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getRunTime() {
        return runTime;
    }

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
