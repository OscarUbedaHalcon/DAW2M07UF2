package edu.fje.daw2.m1_spring_mvc.controladors.controladors;

import edu.fje.daw2.m1_spring_mvc.model.Alumne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal del projecte
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class AlumneController {

    List<Alumne> alumnes = new ArrayList<>();

    @GetMapping("/afegirAlumne")
    public String afegirAlumne(
                        @RequestParam String nom,
                        @RequestParam(defaultValue = "0", required = false) int nota,
                        Model model) {
        alumnes.add(new Alumne(nom, nota));
        model.addAttribute("alumnes", alumnes);
        return "llistarAlumnes";
    }
}
