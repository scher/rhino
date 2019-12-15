package com.bulldozer.simulation.console;

import com.bulldozer.common.Command;
import com.bulldozer.common.CommandType;
import com.bulldozer.domain.bulldozer.IBulldozerController;
import com.bulldozer.domain.site.TraversableSite;
import com.bulldozer.exceptions.ClearProtectedTreeException;
import com.bulldozer.exceptions.UnsupportedCommandException;
import com.bulldozer.reports.ReportItem;
import com.bulldozer.reports.Reportable;
import com.bulldozer.reports.SiteClearingReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsoleSimulationController {
    private final ConsoleView consoleView;
    private final IBulldozerController bulldozer;
    private final TraversableSite site;
    private String[][] map;
    private List<Command> commandHistory = new ArrayList<>();

    public ConsoleSimulationController(ConsoleView consoleView, IBulldozerController bulldozer, TraversableSite site, String[][] map) {
        this.consoleView = consoleView;
        this.bulldozer = bulldozer;
        this.site = site;
        this.map = map;
    }


    public void start() {
        consoleView.renderMap(map);

        executeCommands();

        consoleView.renderIssuedCommands(commandHistory);

        report();
    }

    private void executeCommands() {
        Command command;
        while (true) {
            try {
                command = consoleView.readNextCommand();
                if (command.getType() == CommandType.QUIT) {
                    break;
                }
                commandHistory.add(command);

                executeCommand(command);
            } catch (ClearProtectedTreeException ex) {
                break;
            } catch (UnsupportedCommandException e) {
            } catch (IOException e) {
            }
        }
    }

    private void report() {
        Reportable report = new SiteClearingReport(bulldozer, site);
        List<ReportItem> reportItems = report.generateReport();
        consoleView.renderReport(reportItems);
    }

    private void executeCommand(Command command) {
        switch (command.getType()) {
            case TURN_LEFT:
                bulldozer.turnLeft();
                break;
            case TURN_RIGHT:
                bulldozer.turnRight();
                break;
            case ADVANCE:
                bulldozer.move(command.getDistance());
                break;
        }
    }
}
