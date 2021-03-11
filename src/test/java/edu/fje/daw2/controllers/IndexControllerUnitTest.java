package edu.fje.daw2.controllers;

import edu.fje.daw2.controladors.IndexController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class IndexControllerUnitTest {
    @Test
    void salutar() {
        IndexController controlador = new IndexController();
        Model model = new BindingAwareModelMap();
        String resultat = controlador.salutar("Sergi", model);
        assertEquals("hola", resultat);
        assertEquals("hola", model.asMap().get("nom"));

    }
}
