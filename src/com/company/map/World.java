package com.company.map;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nici on 09.01.2016.
 */
public class World {

    private final Map<String, Continent> continentMap;
    private final Map<String, Territory> territoryMap;

    public World() {
        this.continentMap = new HashMap<>();
        this.territoryMap = new HashMap<>();
    }

    public Continent getContinent(String continentName) {
        return continentMap.get(continentName);
    }

    public Territory getTerritory(String territoryName) {
        return territoryMap.get(territoryName);
    }

    public Collection<Continent> getContinents() {
        return Collections.unmodifiableCollection(continentMap.values());
    }

    public Collection<Territory> getTerritories() {
        return Collections.unmodifiableCollection(territoryMap.values());
    }

    public void addContinent(Continent continent) {
        this.continentMap.put(continent.getName(), continent);
        continent.setWorld(this);
    }

    public void addTerritory(Territory territory) {
        this.territoryMap.put(territory.getName(), territory);
    }

    public Territory byPoint(Point point) {
        for (Territory territory : getTerritories()) {
            if (territory.contains(point)) return territory;
        }

        return null;
    }

}
