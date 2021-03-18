package edu.fje.daw2.m3_spring_persistence.entities;

import java.io.Serializable;

/**
 * Classe entitat que representa un alumne
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
public class Alumne implements Serializable {
    private int id;
    private String nom;
    private int nota;
    private Curs curs;

    public Alumne(String nom, int nota, Curs curs) {
        this.nom = nom;
        this.nota = nota;
        this.curs = curs;
    }

    public Alumne(int id, String nom, int nota, Curs curs) {
        this.id=id;
        this.nom = nom;
        this.nota = nota;
        this.curs = curs;
    }

    public String getNom() {
        return nom;
    }

    public int getNota() {
        return nota;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", nota=" + nota +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumne alumne = (Alumne) o;

        return nom.equals(alumne.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
