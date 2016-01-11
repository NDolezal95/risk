package com.company.map;

import com.company.game.Player;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nici on 09.01.2016.
 */
public class Territory {

    private Continent continent;
    private final String name;
    private Point capital;
    private final List<Patch> patches;
    private final List<Territory> neighbors;

    private Player owner;
    private int army;

    public Territory(String name) {
        this.name = name;
        this.capital = null;
        this.patches = new LinkedList<>();
        this.neighbors = new LinkedList<>();
    }

    protected void setContinent(Continent continent) {
        this.continent = continent;
    }

    public void setCapital(Point capital) {
        this.capital = capital;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setArmy(int army) {
        this.army = army;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getName() {
        return name;
    }

    public List<Patch> getPatches() {
        return Collections.unmodifiableList(patches);
    }

    public Point getCapital() {
        return new Point(capital);
    }

    public List<Territory> getNeighbors() {
        return Collections.unmodifiableList(neighbors);
    }

    public Player getOwner() {
        return owner;
    }

    public int getArmy() {
        return army;
    }

    public void addPatch(Patch patch) {
        patches.add(patch);
        patch.setTerritory(this);
    }

    public void addNeighbor(Territory neighbor) {
        neighbors.add(neighbor);
    }

    public boolean isNeighbor(Territory neighbor) {
        return neighbors.contains(neighbor);
    }

    public boolean contains(Point point) {
        for (Patch patch : patches) {
            if (patch.contains(point)) return true;
        }

        return false;
    }

}
