package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.*;

public class BulldozerController implements IBulldozerController {
    private SiteCleaner bulldozerState;
    private Bulldozer bulldozer;
    private TraversableSite site;

    public BulldozerController(Bulldozer bulldozer, TraversableSite site) {
        this.bulldozer = bulldozer;
        this.site = site;
    }

    public void turnLeft() {
        bulldozer.increaseCommandsCount();
        bulldozer.turnLeft();
    }

    public void turnRight() {
        bulldozer.increaseCommandsCount();
        bulldozer.turnRight();
    }

    public void move(int distance) {
        bulldozerState = initBulldozerState(distance);
        bulldozer.increaseCommandsCount();
        while (distance > 0) {
            ClearableBlock currentBlock = site.move(bulldozer.getDirection());
            currentBlock.clear(bulldozerState);
            distance--;
        }
    }

    void setState(SiteCleaner bulldozerState) {
        this.bulldozerState = bulldozerState;
    }

    private SiteCleaner initBulldozerState(int distance) {
        if (distance == 1) {
            return new StoppingBulldozerState();
        } else {
            return new MovingBulldozerState(distance);
        }
    }
}
