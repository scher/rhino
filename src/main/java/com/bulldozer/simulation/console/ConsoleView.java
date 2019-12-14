package com.bulldozer.simulation.console;

import com.bulldozer.common.Command;
import com.bulldozer.common.CommandType;
import com.bulldozer.exceptions.UnsupportedCommandException;
import com.bulldozer.reports.ReportItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleView {
    public static final String COMMANDS_SUMMERY_MESSAGE = "The simulation has ended at your request. These are the commands you issued:\n";
    public static final String REPORT_MESSAGE = "The costs for this land clearing operation were:\n";
    public static final String THANK_YOU_MESSAGE = "Thankyou for using the Aconex site clearing simulator.\n";
    public static final String BULLDOZER_DIRECTION_MASSAGE = "The bulldozer is currently located at the Northern edge of the site, immediately to the West of the site, and facing East.\n";
    public static final String WELCOME_MESSAGE = "Welcome to the Aconex site clearing simulator. This is a map of the site:\n";
    BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    void renderMap(String[][] map) {
        System.out.println(WELCOME_MESSAGE);
        for (String[] line : map) {
            for (String item : line) {
                System.out.print(item + ' ');
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(BULLDOZER_DIRECTION_MASSAGE);
    }

    Command readNextCommand() throws UnsupportedCommandException, IOException {
        System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit: ");
        String commandString = reader.readLine();
        return interpretCommand(commandString);
    }

    private Command interpretCommand(String commandString) throws UnsupportedCommandException {
        if (commandString.startsWith("l")) {
            return new Command(CommandType.TURN_LEFT);
        } else if (commandString.startsWith("r")) {
            return new Command(CommandType.TURN_RIGHT);
        } else if (commandString.startsWith("q")) {
            return new Command(CommandType.QUIT);
        } else {
            String unsupportedCommandMessage = "Unsupported command";
            if (commandString.startsWith("a")) {
                String distanceStr = commandString.replaceAll("[\\D]", "");
                if (distanceStr.isEmpty()) {
                    System.out.println(unsupportedCommandMessage);
                    throw new UnsupportedCommandException(unsupportedCommandMessage);
                }
                int distance = Integer.parseInt(distanceStr);
                return new Command(CommandType.ADVANCE, distance);
            } else {
                System.out.println(unsupportedCommandMessage);
                throw new UnsupportedCommandException(unsupportedCommandMessage);
            }
        }
    }

    void renderIssuedCommands(List<Command> commands) {
        System.out.println();
        System.out.println(COMMANDS_SUMMERY_MESSAGE);
        for (Command command : commands) {
            System.out.println(command);
        }
        System.out.println();
    }

    void renderReport(List<ReportItem> report) {
        System.out.println(REPORT_MESSAGE);

        for (ReportItem item : report) {
            System.out.println(item);
        }

        System.out.println();
        System.out.println(THANK_YOU_MESSAGE);
    }


}
