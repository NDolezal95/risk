package com.company.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nici on 09.01.2016.
 */
public class WorldParser {

    public static final String COMMAND_PATCH_OF = "patch-of";
    public static final String COMMAND_CAPITAL_OF = "capital-of";
    public static final String COMMAND_NEIGHBORS_OF = "neighbors-of";
    public static final String COMMAND_CONTINET = "continent";

    public static World parse(File file) throws IOException {
        World world = new World();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");

            String command = scanner.next();

            switch (command) {
                case COMMAND_PATCH_OF:
                    Patch patch = new Patch();
                    String name = parseName(scanner);
                    Territory territory = world.getTerritory(name);
                    if (territory == null) {
                        territory = new Territory(name);
                        world.addTerritory(territory);
                    }
                    territory.addPatch(patch);

                    while (scanner.hasNextInt()) {
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        patch.addPoint(x, y);
                    }

                    break;
                case COMMAND_NEIGHBORS_OF:
                    Patch patch1 = new Patch();
                    String name1 = parseName(scanner);
                    Territory territory1 = world.getTerritory(name1);
                    if (territory1 == null) {
                        territory = new Territory(name1);
                        world.addTerritory(territory);
                    }
                    territory1.addPatch(patch1);

                default:
                    System.out.println("unbekanntes kommando: " + command);
                    break;
            }

            if (scanner.hasNext()) {
                System.out.println("nicht ganz eingelesenes kommando: " + command);
            }
        }

        return world;
    }

    private static String parseName(Scanner scanner) {
        String name = "";
        do {
            if (!name.isEmpty()) name += " ";
            name += scanner.next();
        } while (!scanner.hasNextInt());
        return name;
    }

    private WorldParser() {
    }

}
