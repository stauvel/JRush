package org.jrush.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by Seb on 18/11/2015.
 */
public class Candidate {

    @Id
    private String candidateId;

    private String firstName;
    private String lastName;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
