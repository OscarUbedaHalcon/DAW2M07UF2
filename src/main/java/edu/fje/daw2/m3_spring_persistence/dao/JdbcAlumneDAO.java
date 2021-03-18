package edu.fje.daw2.m3_spring_persistence.dao;

import edu.fje.daw2.m3_spring_persistence.entities.Alumne;
import edu.fje.daw2.m3_spring_persistence.entities.Curs;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"SqlResolve","SqlNoDataSourceInspection", "ConstantConditions" })
@Repository
public class JdbcAlumneDAO implements AlumneDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertAlumne;


    private RowMapper<Alumne> alumneMapper =
            ((rs, rowNum) -> new Alumne(rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getInt("nota"),
                    Curs.valueOf(rs.getString("curs"))));

    public JdbcAlumneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertAlumne = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("alumne")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Alumne desar(Alumne alumne) {
        Map<String, Object> parametres = new HashMap<>();
        parametres.put("nom", alumne.getNom());
        parametres.put("nota", alumne.getNota());
        parametres.put("curs", alumne.getCurs());
        Integer id = (Integer) insertAlumne.executeAndReturnKey(parametres);
        return alumne;
    }

    @Override
    public Optional<Alumne> findById(Integer id) {
        if (!existsById(id)) return Optional.empty();
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "select * from alumne where id=?",alumneMapper, id
        ));
    }

    @Override
    public List<Alumne> findAll() {
        return jdbcTemplate.query("select * from alumne",alumneMapper);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from alumne", Long.class);
    }

    @Override
    public void esborrar(Alumne alumne) {
    jdbcTemplate.update("delete from alumne where id=?", alumne.getId());
    }

    @Override
    public boolean existsById(Integer id) {
        return jdbcTemplate.queryForObject("select exists (select 1 from alumne where id=?", Boolean.class, id);
    }
}
