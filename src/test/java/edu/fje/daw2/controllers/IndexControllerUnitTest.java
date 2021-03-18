package edu.fje.daw2.controllers;

import edu.fje.daw2.controladors.IndexController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Controlador de testing que prova el return del mètode salutar i
 * l'atribut usuari del model
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 28.02.21
 */
public class IndexControllerUnitTest {
    @Test
    void salutar() {
        IndexController controlador = new IndexController();
        Model model = new BindingAwareModelMap();
        String resultat = controlador.salutar("Sergi", model);
        assertEquals("salutacio", resultat);
        assertEquals("hola", model.asMap().get("usuari"));
    }
}
