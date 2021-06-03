package ru.owlswing.test_task_rulers_and_planets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.owlswing.test_task_rulers_and_planets.GalaxyDAO.PlanetDAO;
import ru.owlswing.test_task_rulers_and_planets.GalaxyDAO.RulerPlanetDAO;
import ru.owlswing.test_task_rulers_and_planets.GalaxyDAO.RulersDAO;
import ru.owlswing.test_task_rulers_and_planets.models.Planete;
import ru.owlswing.test_task_rulers_and_planets.models.Ruler;

@Controller
public class GalaxyController {

    private final PlanetDAO planetDAO;
    private final RulersDAO rulersDAO;
    private final RulerPlanetDAO rulerPlanetDAO;

    @Autowired
    public GalaxyController(PlanetDAO planetDAO, RulersDAO rulersDAO, RulerPlanetDAO rulerPlanetDAO) {
        this.planetDAO = planetDAO;
        this.rulersDAO = rulersDAO;
        this.rulerPlanetDAO = rulerPlanetDAO;
    }

    @GetMapping("/rulers")
    public String showAllRulers(Model model) {
        model.addAttribute("rulers", rulersDAO.showAllRulers());
        return "all-rulers";
    }

    @GetMapping("/planets")
    public String showAllPlanets(Model model) {
        model.addAttribute("planets", planetDAO.showAllPlanets());
        return "all-planets";
    }

    @GetMapping("/rulers/young")
    public String showYoungRulers(Model model) {
        model.addAttribute("youngRulers", rulersDAO.showYoungRulers());
        return "young-rulers";
    }

    @GetMapping("/no-planet-rulers")
    public String showRulersWithoutPlanets(Model model) {
        model.addAttribute("rulersWoPlanets", rulerPlanetDAO.rulersWoPlanets());
        return "no-planet-rulers";
    }

    @GetMapping("planets/add")
    public String addNewPlanet() {
        return "planets-add";
    }

    @PostMapping()
    public String addNewPlanetPost(@ModelAttribute("planet") Planete planet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "planets-add";
        }
        planetDAO.save(planet);
        return "redirect:/planets";
    }

    @GetMapping("/rulers/add")
    public String addNewRuler(@ModelAttribute("ruler") Ruler ruler) {
        return "rulers-add";
    }

    @PostMapping("/rulers/add")
    public String addNewRulerPost(@ModelAttribute("ruler") Ruler ruler, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/rulers-add";
        }
        rulersDAO.save(ruler);
        return "redirect:/rulers";
    }

    @GetMapping("/order")
    public String orderRuler(){
        return "order";
    }

    @PostMapping("/order")
    public String orderRulerPost(@ModelAttribute("ruler") Ruler ruler, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/planets";
        }
        rulerPlanetDAO.setRuller(ruler);
        return "redirect:/rulers";
    }

    @DeleteMapping("/{planet_id}")
    public String delete(@PathVariable("planet_id") int id){
        planetDAO.delete(id);
        return "redirect:/planets";
    }
}
