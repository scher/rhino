package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;

class StoppingBulldozerState extends AbstractBulldozerState {
    public StoppingBulldozerState(Bulldozer bulldozer, BulldozerController bulldozerController) {
        super(bulldozer, bulldozerController);
    }

    public void clearTree(ClearableBlock block) {
        if (block.isCleared()) {
            bulldozer.useFuel(1);
        } else {
            bulldozer.useFuel(2);
        }
        block.markCleared();
        handleStateChange();
    }

    void handleStateChange() {
        bulldozerController.setState(null);
    }

}
