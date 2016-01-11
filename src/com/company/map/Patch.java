package com.company.map;

import java.awt.*;

/**
 * Created by Nici on 09.01.2016.
 */
public class Patch {

    private Territory territory;
    private final Polygon polygon;

    public Patch() {
        this.territory = null;
        this.polygon = new Polygon();
    }

    protected void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void addPoint(int x, int y) {
        polygon.addPoint(x, y);
    }

    public boolean contains(Point point) {
        return polygon.contains(point);
    }

}
