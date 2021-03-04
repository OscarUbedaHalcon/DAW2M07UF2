package edu.fje.daw2.m2_spring_rest.controladors;

import edu.fje.daw2.m1_spring_mvc.model.Alumne;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Controlador principal del projecte basat en REST
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 04.03.21
 */
@RestController
public class AlumneRestController {

    Set<Alumne> alumnes = new HashSet<>();

    @PostMapping("/afegirAlumne")
    public Alumne afegirAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.add(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }

    @DeleteMapping("/esborrarAlumne")
    public Alumne esborrarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.remove(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }
    @PutMapping("/modificarAlumne")
    public Alumne modificarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.remove(a);
        alumnes.add(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }

    @GetMapping("/llistarAlumnes")
    public Set<Alumne> llistarAlumnes(Model model){
        model.addAttribute("alumnes", alumnes);
        return alumnes;
    }
}
