package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;
import com.bulldozer.domain.site.SiteCleaner;
import com.bulldozer.domain.site.TraversableSite;

class BulldozerController implements IBulldozerController {
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
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must not be negative,but got " + distance);
        }
        bulldozerState = CleaningStateFactory.initBulldozerState(distance, bulldozer, this);
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
}
