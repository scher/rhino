package com.bulldozer.common;

public class Command {
    private CommandType type;
    private Integer distance = null;

    public Command(CommandType type) {
        this.type = type;
    }

    public Command(CommandType type, int distance) {
        this.type = type;
        this.distance = distance;
    }

    @Override
    public String toString() {
        String result = type.toString();
        if (distance != null) {
            result += " " + distance;
        }
        return result;
    }

    public CommandType getType() {
        return type;
    }

    public Integer getDistance() {
        return distance;
    }
}
