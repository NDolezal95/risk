package com.company.map;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nici on 09.01.2016.
 */
public class Continent {

    private World world;
    private final String name;
    private final List<Territory> territories;
    private int reinforcement;

    public Continent(String name) {
        this.name = name;
        this.territories = new LinkedList<>();
        this.reinforcement = 0;
    }

    protected void setWorld(World world) {
        this.world = world;
    }

    public void setReinforcement(int reinforcement) {
        this.reinforcement = reinforcement;
    }

    public String getName() {
        return name;
    }

    public int getReinforcement() {
        return reinforcement;
    }

    public List<Territory> getTerritories() {
        return Collections.unmodifiableList(territories);
    }

    public void addTerritory(Territory territory) {
        territories.add(territory);
        territory.setContinent(this);
    }

}
