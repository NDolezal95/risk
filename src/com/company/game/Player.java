package com.company.game;

import java.awt.*;

/**
 * Created by Nici on 09.01.2016.
 */
public class Player {

    private final String name;
    private Color color;

    public Player(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

}
