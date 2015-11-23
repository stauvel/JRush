package org.jrush.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Seb on 23/11/2015.
 */
public class Activity {

    public enum Type {READ_PREDICATE, SUBMIT_ANSWER_OK, READ_ANSWER, SUBMIT_ANSWER_BAD}

    @Id
    private String activityId;
    private Date date = new Date();
    private Exercice exercice;
    private Type type;

    public Activity() {
    }

    public Activity(Exercice exercice, Type type) {
        this.exercice = exercice;
        this.type = type;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }
}
