package ru.owlswing.test_task_rulers_and_planets.models;

public class RulerPlanet {

    private int id;

    private int rulerId;

    private int planetId;

    public RulerPlanet(){

    }

    public RulerPlanet(int rulerId, int planetId) {
        this.rulerId = rulerId;
        this.planetId = planetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRulerId() {
        return rulerId;
    }

    public void setRulerId(int rulerId) {
        this.rulerId = rulerId;
    }

    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }
}
