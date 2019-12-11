package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;
import com.bulldozer.exceptions.ClearProtectedTreeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class StoppedBulldozerStateTest {

    private Bulldozer bulldozerMock;
    private BulldozerController bulldozerControllerMock;
    private StoppedBulldozerState classToTest;
    private ClearableBlock clearableBlockMock;

    @BeforeEach
    void setup() {
        bulldozerMock = mock(Bulldozer.class);
        bulldozerControllerMock = mock(BulldozerController.class);
        classToTest = new StoppedBulldozerState(bulldozerMock, bulldozerControllerMock);
        clearableBlockMock = mock(ClearableBlock.class);
    }

    @Test
    void clearPlain() {
        when(clearableBlockMock.isCleared()).thenReturn(true);

        classToTest.clearRock(clearableBlockMock);

        verify(bulldozerMock).useFuel(1);
        verify(bulldozerMock, times(0)).damagePaint();
        verify(clearableBlockMock).markCleared();
    }

    @Test
    void clearRockClearedLand() {
        when(clearableBlockMock.isCleared()).thenReturn(true);

        classToTest.clearRock(clearableBlockMock);

        verify(bulldozerMock).useFuel(1);
        verify(bulldozerMock, times(0)).damagePaint();
        verify(clearableBlockMock).markCleared();
    }

    @Test
    void clearRockUnclearedLand() {
        when(clearableBlockMock.isCleared()).thenReturn(false);

        classToTest.clearRock(clearableBlockMock);

        verify(bulldozerMock).useFuel(2);
        verify(bulldozerMock, times(0)).damagePaint();
        verify(clearableBlockMock).markCleared();
    }

    @Test
    void clearProtectedTreeThrowsException() {
        Assertions.assertThrows(ClearProtectedTreeException.class, () ->
                classToTest.clearProtectedTree(clearableBlockMock));
        verify(clearableBlockMock).setProtectedTreeDestroyed();
    }

    @Test
    void clearTreeUnclearedLand() {
        when(clearableBlockMock.isCleared()).thenReturn(false);

        classToTest.clearTree(clearableBlockMock);

        verify(bulldozerMock).useFuel(2);
        verify(bulldozerMock, times(0)).damagePaint();
        verify(clearableBlockMock).markCleared();
    }

    @Test
    void clearTreeClearedLand() {
        when(clearableBlockMock.isCleared()).thenReturn(true);

        classToTest.clearTree(clearableBlockMock);

        verify(bulldozerMock).useFuel(1);
        verify(bulldozerMock, times(0)).damagePaint();
        verify(clearableBlockMock).markCleared();
    }

    @Test
    void handleStateChangeIsCalled() {
        classToTest.clearTree(clearableBlockMock);

        verify(bulldozerControllerMock).setState(null);
    }

    @Test
    void throwsIllegalStateException() {
        classToTest.clearTree(clearableBlockMock);
        Assertions.assertThrows(
                IllegalStateException.class,
                () -> classToTest.clearTree(clearableBlockMock));

        verify(bulldozerControllerMock).setState(null);
    }
}