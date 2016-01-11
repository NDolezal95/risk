package com.company.game;

import com.company.map.World;

/**
 * Created by Nici on 09.01.2016.
 */
public class Game {

    private final World world;

    public Game(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }
}
