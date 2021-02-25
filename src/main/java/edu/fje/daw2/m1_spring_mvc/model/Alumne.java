package edu.fje.daw2.m1_spring_mvc.model;

import java.io.Serializable;

/**
 * Classe entitat que representa un alumne
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
public class Alumne  implements Serializable {
    private String nom;
    private int nota;

    public Alumne(String nom, int nota) {
        this.nom = nom;
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", nota=" + nota +
                '}';
    }
}
