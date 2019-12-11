package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;

class StoppedBulldozerState extends AbstractBulldozerState {
    private boolean commandInvoked = false;

    public StoppedBulldozerState(Bulldozer bulldozer, BulldozerController bulldozerController) {
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
        if (commandInvoked) {
            throw new IllegalStateException("Stopped bulldozer can be called only once");
        }
        commandInvoked = true;
        bulldozerController.setState(null);
    }

}
