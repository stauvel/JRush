package org.jrush.domain;

import org.jrush.exercice.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Seb on 18/11/2015.
 */
public abstract class Exercice {

    @Id
    private String uuid;

    private Data data;

    private Date dateCreation;

    private Candidate candidate;

    public abstract void init();
    public abstract Data solve();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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
}
