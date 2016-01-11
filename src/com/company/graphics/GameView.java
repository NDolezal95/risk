package com.company.graphics;

import com.company.game.Game;
import com.company.map.Patch;
import com.company.map.Territory;
import com.company.map.World;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by Nici on 09.01.2016.
 */
public class GameView extends JComponent {

    private static final Stroke STROKE = new BasicStroke(2, BasicStroke.JOIN_ROUND, BasicStroke.CAP_ROUND);
    private static final Color BACKGROUND = new Color(150, 204, 255);
    private static final Color TERRITORY_FILL = Color.LIGHT_GRAY;
    private static final Color TERRITORY_DRAW = Color.GRAY;

    private static void paintTerritory(Graphics2D g, Territory territory, Color fill, Color draw) {
        for (Patch patch : territory.getPatches()) {
            paintPatch(g, patch, fill, draw);
        }
    }

    private static void paintPatch(Graphics2D g, Patch patch, Color fill, Color draw) {
        g.setColor(fill);
        g.fillPolygon(patch.getPolygon());
        g.setColor(draw);
        g.drawPolygon(patch.getPolygon());
    }

    private final Game game;

    private Territory hover;
    private Territory selected;

    private final Timer timer;

    private final ActionListener redrawListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    };

    private final MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            hover = getWorld().byPoint(e.getPoint());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            selected = getWorld().byPoint(e.getPoint());
        }
    };

    public GameView(Game game) {
        this.game = game;

        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);

        this.timer = new Timer(40, redrawListener);
        this.timer.start();
    }

    public World getWorld() {
        return game.getWorld();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());

        paintTerritories(g);
    }

    private void paintTerritories(Graphics2D g) {
        g.setStroke(STROKE);

        for (Territory territory : getWorld().getTerritories()) {
            if (territory == hover) continue;
            if (territory == selected) continue;
            if (selected != null && selected.isNeighbor(territory)) continue;
            paintTerritory(g, territory, TERRITORY_FILL, TERRITORY_DRAW);
        }

        if (hover != null) {
            paintTerritory(g, hover, Color.YELLOW, TERRITORY_DRAW);
        }

        if (selected != null) {
            paintTerritory(g, selected, Color.ORANGE, TERRITORY_DRAW);

            for (Territory territory : selected.getNeighbors()) {
                paintTerritory(g, selected, Color.GREEN, TERRITORY_DRAW);
            }
        }
    }

}
