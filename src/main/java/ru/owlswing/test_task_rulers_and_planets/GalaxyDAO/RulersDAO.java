package ru.owlswing.test_task_rulers_and_planets.GalaxyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.owlswing.test_task_rulers_and_planets.models.Planete;
import ru.owlswing.test_task_rulers_and_planets.models.Ruler;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RulersDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RulersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ruler> showAllRulers(){
        return jdbcTemplate.query("SELECT * FROM ruler", new BeanPropertyRowMapper<>(Ruler.class));
    }

    public List<Ruler> showYoungRulers(){
        return jdbcTemplate.query("SELECT * FROM ruler ORDERED BY age DESC LIMIT 10",
                new BeanPropertyRowMapper<>(Ruler.class)).stream().collect(Collectors.toList());
    }

    public Planete show(int id){
        return jdbcTemplate.query("SELECT * FROM ruler WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Planete.class)).stream().findAny().orElse(null);
    }

    public int save(Ruler ruler){
        return jdbcTemplate.update("INSERT INTO ruler VALUES (1,?,?)",ruler.getName(), ruler.getAge());
    }
}

