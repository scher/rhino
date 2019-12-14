package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;

import java.util.function.Predicate;

class Site implements TraversableSite {
    private ClearableBlock[][] siteBlocks;
    private int currentX = -1;
    private int currentY = 0;

    Site(ClearableBlock[][] siteBlocks) {
        this.siteBlocks = siteBlocks;
    }

    public ClearableBlock move(Direction direction) {
        currentX += direction.getXincrement();
        currentY += direction.getYincrement();
        return siteBlocks[currentY][currentX];
    }

    /**
     * Iterates over the site and sums elements for which the passed predicate evaluates to true;
     *
     * @param predicate predicate to test if current element needs to be added to result sum or not
     * @return sum of all the elements for which the predicate evaluated to true;
     */
    private int iterateAndCount(Predicate<ClearableBlock> predicate) {
        int res = 0;
        for (ClearableBlock[] siteBlocks : siteBlocks) {
            for (ClearableBlock clearableBlock : siteBlocks) {
                if (predicate.test(clearableBlock)) {
                    res++;
                }
            }
        }
        return res;
    }

    @Override
    public int getUnclearedBlocksAmount() {
        return iterateAndCount((ClearableBlock b) -> !b.isCleared());
    }

    @Override
    public int getProtectedTreeDestroyedAmount() {
        return iterateAndCount(ClearableBlock::isProtectedTreeDestroyed);
    }
}
