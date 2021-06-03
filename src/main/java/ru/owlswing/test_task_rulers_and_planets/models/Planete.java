package ru.owlswing.test_task_rulers_and_planets.models;

import javax.persistence.Entity;


public class Planete {

    private int id;

    private String name;

    private int rulerId;

    public Planete(){

    }

    public Planete(int rulerId, String name){
        this.rulerId = rulerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRulerId() {
        return rulerId;
    }

    public void setRulerId(int rulerId) {
        this.rulerId = rulerId;
    }


}
