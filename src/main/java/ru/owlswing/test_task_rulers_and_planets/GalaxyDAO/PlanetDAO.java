package ru.owlswing.test_task_rulers_and_planets.GalaxyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.owlswing.test_task_rulers_and_planets.models.Planete;

import java.util.List;

@Component
public class PlanetDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlanetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Planete> showAllPlanets(){
        return jdbcTemplate.query("SELECT * FROM planet", new BeanPropertyRowMapper<>(Planete.class));
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM planet WHERE id=?", id);
    }
    public void save(Planete planet){
        jdbcTemplate.update("INSERT INTO planet VALUES (1,?,?)",planet.getName(), planet.getRulerId());
    }
}
