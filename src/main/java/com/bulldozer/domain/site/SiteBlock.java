package com.bulldozer.domain.site;

public enum SiteBlock implements ClearableBlock {
    PLAIN {
        @Override
        public void clear(SiteCleaner siteCleaner) {
            siteCleaner.clearPlain(this);
        }
    }, ROCK {
        @Override
        public void clear(SiteCleaner siteCleaner) {
            siteCleaner.clearRock(this);
        }
    }, TREE {
        @Override
        public void clear(SiteCleaner siteCleaner) {
            siteCleaner.clearTree(this);
        }
    }, PROTECTED_TREE {
        @Override
        public void clear(SiteCleaner siteCleaner) {
            siteCleaner.clearProtectedTree(this);
        }

        @Override
        public boolean isCleared() {
            return true;
        }
    };

    private boolean cleared;
    private boolean protectedTreeDestroyed;

    public abstract void clear(SiteCleaner siteCleaner);

    public boolean isCleared() {
        return cleared;
    }

    public void markCleared() {
        this.cleared = true;
    }

    public void setProtectedTreeDestroyed() {
        this.protectedTreeDestroyed = true;
    }
}
