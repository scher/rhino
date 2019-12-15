package com.bulldozer.simulation.console;

import com.bulldozer.domain.bulldozer.BulldozerFactory;
import com.bulldozer.domain.bulldozer.IBulldozerController;
import com.bulldozer.domain.site.SiteFactory;
import com.bulldozer.domain.site.TraversableSite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsoleSimulationRunner {

    public static void main(String[] args) {
        String[][] input = readFile(args[0]);
        ConsoleView consoleView = new ConsoleView();
        TraversableSite site = SiteFactory.createSite(input);
        IBulldozerController bulldozer = BulldozerFactory.createBulldozer(site);
        ConsoleSimulationController consoleSimulationController = new ConsoleSimulationController(consoleView, bulldozer, site, input);
        consoleSimulationController.start();
    }

    private static String[][] readFile(String fileName) {
        BufferedReader reader;
        List<String[]> result = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] blocksStr = line.split("");
                result.add(blocksStr);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toArray(new String[result.size()][result.get(0).length]);
    }
}
