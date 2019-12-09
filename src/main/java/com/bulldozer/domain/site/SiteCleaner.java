package com.bulldozer.domain.site;

import com.bulldozer.exceptions.ClearProtectedTreeException;

public interface SiteCleaner {
    void clearPlain(ClearableBlock siteBlock);

    void clearRock(ClearableBlock siteBlock);

    void clearTree(ClearableBlock siteBlock);

    void clearProtectedTree(ClearableBlock siteBlock) throws ClearProtectedTreeException;
}
