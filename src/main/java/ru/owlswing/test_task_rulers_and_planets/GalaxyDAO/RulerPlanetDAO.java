package ru.owlswing.test_task_rulers_and_planets.GalaxyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.owlswing.test_task_rulers_and_planets.models.Planete;
import ru.owlswing.test_task_rulers_and_planets.models.Ruler;
import ru.owlswing.test_task_rulers_and_planets.models.RulerPlanet;

import java.util.List;

@Component
public class RulerPlanetDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RulerPlanetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RulerPlanet> rulersWoPlanets(){
        return jdbcTemplate.query("SELECT * FROM Ruler_of_planet WHERE planet_id = null",
                new BeanPropertyRowMapper<>(RulerPlanet.class));
    }

    public void setRuller(Ruler ruler){
        jdbcTemplate.update("INSERT INTO Ruler_of_planet VALUE(?) WHERE  planet_id = ?", ruler.getId());
    }
}

