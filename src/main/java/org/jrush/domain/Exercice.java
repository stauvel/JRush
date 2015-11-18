package org.jrush.domain;

/**
 * Created by Seb on 18/11/2015.
 */
public class Exercice {

    private String name;

    private String data;

    public Exercice(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
