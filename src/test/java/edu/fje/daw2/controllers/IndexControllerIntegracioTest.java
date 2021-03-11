package edu.fje.daw2.controllers;

import edu.fje.daw2.controladors.IndexController;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IndexController.class)
public class IndexControllerIntegracioTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSalutacioSenseNom() throws Exception {
        mvc.perform(get("/salutacio").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hola"))
                .andExpect(model().attribute("nom", is("sergi")));
    }
    @Test
    public void testSalutacioAmbNom() throws Exception {
        mvc.perform(get("/salutacio").param("nom", "sergi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hola"))
                .andExpect(model().attribute("nom", is("sergi")));
    }
}
