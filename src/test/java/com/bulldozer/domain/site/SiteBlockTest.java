package com.bulldozer.domain.site;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SiteBlockTest {

    private SiteCleaner siteCleaner;

    @BeforeEach
    void setUp() {
        siteCleaner = mock(SiteCleaner.class);
    }

    @Test
    void clearCallCorrectVisitor() {
        SiteBlock plain = new SiteBlock(SiteBlock.PLAIN);
        plain.clear(siteCleaner);
        verify(siteCleaner).clearPlain(plain);
        SiteBlock rock = new SiteBlock(SiteBlock.ROCK);
        rock.clear(siteCleaner);
        verify(siteCleaner).clearRock(rock);
        SiteBlock tree = new SiteBlock(SiteBlock.TREE);
        tree.clear(siteCleaner);
        verify(siteCleaner).clearTree(tree);
        SiteBlock protectedTree = new SiteBlock(SiteBlock.PROTECTED_TREE);
        protectedTree.clear(siteCleaner);
        verify(siteCleaner).clearProtectedTree(protectedTree);
    }

    @Test
    void markCleared() {
        SiteBlock classToTest = new SiteBlock(SiteBlock.PLAIN);
        classToTest.markCleared();
        Assertions.assertTrue(classToTest.isCleared());
    }

    @Test
    void setProtectedTreeDestroyed() {
        SiteBlock classToTest = new SiteBlock(SiteBlock.PLAIN);
        classToTest.setProtectedTreeDestroyed();
        Assertions.assertTrue(classToTest.isProtectedTreeDestroyed());
    }
}