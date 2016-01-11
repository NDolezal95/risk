package com.company.main;

import com.company.game.Game;
import com.company.graphics.GameView;
import com.company.map.World;
import com.company.map.WorldParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nici on 09.01.2016.
 */
public class Main {

    public static final int WIDTH = 1250;
    public static final int HEIGHT = 650;
    private static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);

    public static void main(String[] args) {
        // Map laden
        File file = new File("C:\\Users\\Nici\\Desktop\\pk15w19p_Abschlussbeispiel\\pk15w19p_Abschlussbeispiel\\world.map");
        World world = null;

        try {
            world = WorldParser.parse(file);
        } catch (IOException e) {
            System.out.println("Die Datei konnte nicht geladen werden");
            return;
        }

        // Game erstellen
        Game game = new Game(world);

        // Map an gameView übergeben
        GameView gameView = new GameView(game);
        gameView.setMinimumSize(DIMENSION);
        gameView.setPreferredSize(DIMENSION);
        gameView.setMaximumSize(DIMENSION);

        JFrame frame = new JFrame("");
        frame.add(gameView);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
