package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.TraversableSite;

public class BulldozerFactory {
    public static IBulldozerController createBulldozer(TraversableSite site) {
        return new BulldozerController(new Bulldozer(), site);
    }
}
