package com.bulldozer.domain.site;

import java.util.function.BiConsumer;

class SiteBlock implements ClearableBlock {
    static final BiConsumer<SiteCleaner, SiteBlock> PLAIN = SiteCleaner::clearPlain;
    static final BiConsumer<SiteCleaner, SiteBlock> ROCK = SiteCleaner::clearRock;
    static final BiConsumer<SiteCleaner, SiteBlock> TREE = SiteCleaner::clearTree;
    static final BiConsumer<SiteCleaner, SiteBlock> PROTECTED_TREE = SiteCleaner::clearProtectedTree;

    private boolean cleared;
    private boolean protectedTreeDestroyed;
    private BiConsumer<SiteCleaner, SiteBlock> clearingConsumer;

    SiteBlock(BiConsumer<SiteCleaner, SiteBlock> clearingConsumer) {
        this.clearingConsumer = clearingConsumer;
    }

    public void clear(SiteCleaner siteCleaner) {
        clearingConsumer.accept(siteCleaner, this);
    }

    public boolean isCleared() {
        return cleared;
    }

    public void markCleared() {
        this.cleared = true;
    }

    public void setProtectedTreeDestroyed() {
        this.protectedTreeDestroyed = true;
    }

    public boolean isProtectedTreeDestroyed() {
        return protectedTreeDestroyed;
    }
}
