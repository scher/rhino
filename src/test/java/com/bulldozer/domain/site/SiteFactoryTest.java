package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SiteFactoryTest {

    private SiteCleaner siteCleanerMock;
    private Site site;

    @BeforeEach
    void setUp() {
        String[][] inputMap = {
                {"o", "r"},
                {"t", "T"}
        };
        site = SiteFactory.createSite(inputMap);
        siteCleanerMock = mock(SiteCleaner.class);
    }

    @Test
    void createSiteCreatesPlain() {
        ClearableBlock block = site.move(Direction.EAST);
        block.clear(siteCleanerMock);
        verify(siteCleanerMock, times(1)).clearPlain(any());
        verify(siteCleanerMock, times(0)).clearRock(any());
        verify(siteCleanerMock, times(0)).clearTree(any());
        verify(siteCleanerMock, times(0)).clearProtectedTree(any());
    }

    @Test
    void createSiteCreatesRock() {
        site.move(Direction.EAST);
        ClearableBlock block = site.move(Direction.EAST);
        block.clear(siteCleanerMock);
        verify(siteCleanerMock, times(0)).clearPlain(any());
        verify(siteCleanerMock, times(1)).clearRock(any());
        verify(siteCleanerMock, times(0)).clearTree(any());
        verify(siteCleanerMock, times(0)).clearProtectedTree(any());
    }

    @Test
    void createSiteCreatesTree() {
        site.move(Direction.EAST);
        ClearableBlock block = site.move(Direction.SOUTH);
        block.clear(siteCleanerMock);
        verify(siteCleanerMock, times(0)).clearPlain(any());
        verify(siteCleanerMock, times(0)).clearRock(any());
        verify(siteCleanerMock, times(1)).clearTree(any());
        verify(siteCleanerMock, times(0)).clearProtectedTree(any());
    }

    @Test
    void createSiteCreatesProtectedTree() {
        site.move(Direction.EAST);
        site.move(Direction.SOUTH);
        ClearableBlock block = site.move(Direction.EAST);
        block.clear(siteCleanerMock);
        verify(siteCleanerMock, times(0)).clearPlain(any());
        verify(siteCleanerMock, times(0)).clearRock(any());
        verify(siteCleanerMock, times(0)).clearTree(any());
        verify(siteCleanerMock, times(1)).clearProtectedTree(any());
    }

    @Test
    void createSiteThrowsException() {
        String[][] inputMap = {
                {"qwerty", "r"},
                {"t", "T"}
        };
        Assertions.assertThrows(IllegalArgumentException.class, () -> SiteFactory.createSite(inputMap));


    }
}