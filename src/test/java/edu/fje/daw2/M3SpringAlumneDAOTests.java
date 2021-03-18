package edu.fje.daw2;

import edu.fje.daw2.m3_spring_persistence.dao.AlumneDAO;
import edu.fje.daw2.m3_spring_persistence.entities.Alumne;
import edu.fje.daw2.m3_spring_persistence.entities.Curs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class M3SpringAlumneDAOTests {

    @Autowired
    private AlumneDAO dao;
    @Test
    public void desar() {
        Alumne alumne =  new Alumne("sergi", 8, Curs.DAW2);
        alumne = dao.desar(alumne);
        assertNotNull(alumne.getId());
    }

}
