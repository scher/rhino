package com.bulldozer.simulation.console;

import com.bulldozer.common.Command;
import com.bulldozer.common.CommandType;
import com.bulldozer.exceptions.UnsupportedCommandException;
import com.bulldozer.reports.ReportItem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * THIS CLASS IS FOR DEV TESTING ONLY
 * DO NOT USE IN PRODUCTION
 */
class ConsoleViewManualTest {
    public static void main(String[] args) throws IOException, UnsupportedCommandException {
//        testRenderMap();
//        testReadNextCommand();
//
//        testRenderIssuedCommands();
//        testrenderReport();
    }

    private static void testrenderReport() {
        ConsoleView consoleView = new ConsoleView();
        List<ReportItem> reportItems = Arrays.asList(
                new ReportItem("qwer", 1, 2),
                new ReportItem("zzzzz", 3, 10)
        );
        consoleView.renderReport(reportItems);
    }

    private static void testRenderIssuedCommands() {
        ConsoleView consoleView = new ConsoleView();
        List<Command> commands = Arrays.asList(
                new Command(CommandType.TURN_LEFT),
                new Command(CommandType.TURN_RIGHT),
                new Command(CommandType.ADVANCE, 4),
                new Command(CommandType.QUIT)
        );
        consoleView.renderIssuedCommands(commands);
    }


    static void testRenderMap() {
        String[][] map = {
                {"o", "o", "t", "o", "o", "o", "o", "o", "o", "o"},
                {"o", "o", "o", "o", "o", "o", "o", "T", "o", "o"},
                {"r", "r", "r", "o", "o", "o", "o", "T", "o", "o"},
                {"r", "r", "r", "r", "o", "o", "o", "o", "o", "o"},
                {"r", "r", "r", "r", "r", "t", "o", "o", "o", "o"}
        };

        ConsoleView consoleView = new ConsoleView();
        consoleView.renderMap(map);
    }

    static void testReadNextCommand() throws IOException, UnsupportedCommandException {
        ConsoleView consoleView = new ConsoleView();

        Command command;
        while (true) {
            command = consoleView.readNextCommand();
            System.out.println(command);
            if (command.getType() == CommandType.QUIT) {
                return;
            }
        }
    }
}
