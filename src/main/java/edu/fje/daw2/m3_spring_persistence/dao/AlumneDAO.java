package edu.fje.daw2.m3_spring_persistence.dao;

import edu.fje.daw2.m3_spring_persistence.entities.Alumne;

import java.util.List;
import java.util.Optional;

public interface AlumneDAO {
    Alumne desar(Alumne alumne);
    Optional<Alumne> findById(Integer id);
    List<Alumne> findAll();
    long count();
    void esborrar(Alumne alumne);
    boolean existsById(Integer id);
}
