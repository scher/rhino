package com.bulldozer.domain.bulldozer;

import com.bulldozer.common.Direction;

public class Bulldozer {
    private int fuelUsed = 0;
    private int paintDamage = 0;
    private int commandsReceived = 0;
    private Direction direction = Direction.EAST;

    public void useFuel(int amount) {
        fuelUsed += amount;
    }

    public void damagePaint() {
        paintDamage++;
    }

    public void increaseCommandsCount() {
        commandsReceived++;
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getUsedFuelAmount() {
        return fuelUsed;
    }

    public int getDamagedPaintAmount() {
        return paintDamage;
    }

    public int getCommandsCount() {
        return commandsReceived;
    }
}