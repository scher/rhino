package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Site {
    private SiteBlock[][] siteBlocks;
    private Location current;
    public SiteBlock move(Direction direction) {
        throw new NotImplementedException();
    }

    private class Location {
        int x;
        int y;
    }
}
