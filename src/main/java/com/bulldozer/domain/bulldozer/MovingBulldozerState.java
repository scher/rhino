package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;

class MovingBulldozerState extends AbstractBulldozerState {
    private int distance;

    MovingBulldozerState(Bulldozer bulldozer, BulldozerController bulldozerController, int distance) {
        super(bulldozer, bulldozerController);
        this.distance = distance;
    }

    public void clearTree(ClearableBlock block) {
        if (block.isCleared()) {
            bulldozer.useFuel(1);
        } else {
            bulldozer.damagePaint();
            bulldozer.useFuel(2);
        }
        block.markCleared();
        handleStateChange();
    }

    void handleStateChange() {
        if (distance == 1) {
            bulldozerController.setState(new StoppingBulldozerState());
        }
    }
}
