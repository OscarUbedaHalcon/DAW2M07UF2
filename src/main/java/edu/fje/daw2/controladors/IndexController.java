package edu.fje.daw2.controladors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador principal del projecte
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class IndexController {
    @GetMapping("/salutacio")
    public String salutar(
            @RequestParam(defaultValue = "sergi", required = false) String nom,
            Model model) {
        model.addAttribute("usuari", nom);
        return "salutacio";
    }
}
