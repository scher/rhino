package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.SiteCleaner;

class CleaningStateFactory {
    static SiteCleaner initBulldozerState(int distance, Bulldozer bulldozer, BulldozerController controller) {
        if (distance < 1) {
            throw new IllegalArgumentException("Distance must be more that zero, but got " + distance);
        }
        if (distance == 1) {
            return new StoppedBulldozerState(bulldozer, controller);
        } else {
            return new MovingBulldozerState(bulldozer, controller, distance);
        }
    }
}
