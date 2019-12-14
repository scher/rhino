package com.bulldozer.domain.site;

public interface ClearableBlock {
    void clear(SiteCleaner visitor);
    void markCleared();
    boolean isCleared();

    void setProtectedTreeDestroyed();

    boolean isProtectedTreeDestroyed();
}
