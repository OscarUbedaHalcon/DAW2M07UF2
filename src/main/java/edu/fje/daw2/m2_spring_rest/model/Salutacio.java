package edu.fje.daw2.m2_spring_rest.model;

public class Salutacio {

    private String missatge;

    public Salutacio(String missatge) {
        this.missatge = missatge;
    }

    public String getMissatge() {
        return missatge;
    }

    public void setMissatge(String missatge) {
        this.missatge = missatge;
    }
}
