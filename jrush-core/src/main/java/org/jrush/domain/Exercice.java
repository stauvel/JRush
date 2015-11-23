package org.jrush.domain;

import org.jrush.exercice.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Seb on 18/11/2015.
 */
public class Exercice {

    @Id
    private String exerciceId;

    private Date dateCreation;

    private Candidate candidate;

    private Data data;

    private String name;

    public String getExerciceId() {
        return exerciceId;
    }

    public void setExerciceId(String exerciceId) {
        this.exerciceId = exerciceId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
