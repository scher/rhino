package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;
import com.bulldozer.domain.site.SiteCleaner;
import com.bulldozer.exceptions.ClearProtectedTreeException;

abstract class AbstractBulldozerState implements SiteCleaner {
    Bulldozer bulldozer;
    BulldozerController bulldozerController;

    AbstractBulldozerState(Bulldozer bulldozer, BulldozerController bulldozerController) {
        this.bulldozer = bulldozer;
        this.bulldozerController = bulldozerController;
    }

    public void clearPlain(ClearableBlock block) {
        bulldozer.useFuel(1);
        block.markCleared();
        handleStateChange();
    }

    public void clearRock(ClearableBlock block) {
        if (block.isCleared()) {
            bulldozer.useFuel(1);
        } else {
            bulldozer.useFuel(2);
        }
        block.markCleared();
        handleStateChange();
    }

    abstract void handleStateChange();

    public void clearProtectedTree(ClearableBlock block) throws ClearProtectedTreeException {
        block.setProtectedTreeDestroyed();
        throw new ClearProtectedTreeException();
    }
}
