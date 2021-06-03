package ru.owlswing.test_task_rulers_and_planets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("title", "Main page");
        return "home";
    }
}
