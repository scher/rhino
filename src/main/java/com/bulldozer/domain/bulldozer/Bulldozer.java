package com.bulldozer.domain.bulldozer;

import com.bulldozer.common.Direction;

class Bulldozer {
    private int fuelUsed = 0;
    private int paintDamage = 0;
    private int commandsReceived = 0;
    private Direction direction = Direction.EAST;

    void useFuel(int amount) {
        fuelUsed += amount;
    }

    void damagePaint() {
        paintDamage++;
    }

    void increaseCommandsCount() {
        commandsReceived++;
    }

    void turnRight() {
        direction = direction.right();
    }

    void turnLeft() {
        direction = direction.left();
    }

    Direction getDirection() {
        return direction;
    }

    int getUsedFuelAmount() {
        return fuelUsed;
    }

    int getDamagedPaintAmount() {
        return paintDamage;
    }

    int getCommandsCount() {
        return commandsReceived;
    }
}