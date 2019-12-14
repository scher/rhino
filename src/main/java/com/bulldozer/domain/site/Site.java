package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;

class Site implements TraversableSite {
    private ClearableBlock[][] siteBlocks;
    private int currentX = -1;
    private int currentY = 0;

    public Site(ClearableBlock[][] siteBlocks) {
        this.siteBlocks = siteBlocks;
    }

    public ClearableBlock move(Direction direction) {
        currentX += direction.getXincrement();
        currentY += direction.getYincrement();
        return siteBlocks[currentY][currentX];
    }
}
