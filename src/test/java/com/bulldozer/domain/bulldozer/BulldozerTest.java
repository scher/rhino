package com.bulldozer.domain.bulldozer;

import com.bulldozer.common.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BulldozerTest {

    private Bulldozer bulldozer;

    @BeforeEach
    void setUp() {
        bulldozer = new Bulldozer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initialDirectionEast() {
        Assertions.assertEquals(bulldozer.getDirection(), Direction.EAST);
    }

    @Test
    void useFuel() {
        bulldozer.useFuel(2);
        Assertions.assertEquals(bulldozer.getUsedFuelAmount(), 2);
    }

    @Test
    void damagePaint() {
        bulldozer.damagePaint();
        Assertions.assertEquals(bulldozer.getDamagedPaintAmount(), 1);
    }

    @Test
    void increaseCommandsCount() {
        bulldozer.increaseCommandsCount();
        Assertions.assertEquals(bulldozer.getCommandsCount(), 1);
    }

    @Test
    void turnRight() {
        bulldozer.turnRight();
        Assertions.assertEquals(bulldozer.getDirection(), Direction.SOUTH);
    }

    @Test
    void turnLeft() {
        bulldozer.turnLeft();
        Assertions.assertEquals(bulldozer.getDirection(), Direction.NORTH);
    }
}