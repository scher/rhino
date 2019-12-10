package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.ClearableBlock;
import com.bulldozer.domain.site.TraversableSite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BulldozerControllerTest {

    Bulldozer bulldozerMock;
    TraversableSite siteMock;
    BulldozerController classToTest;

    @BeforeEach
    void setUp() {
        bulldozerMock = mock(Bulldozer.class);
        siteMock = mock(TraversableSite.class);
    }

    @Test
    void turnLeft() {
        BulldozerController classToTest = new BulldozerController(bulldozerMock, siteMock);
        classToTest.turnLeft();
        verify(bulldozerMock).increaseCommandsCount();
        verify(bulldozerMock).turnLeft();
    }

    @Test
    void turnRight() {
        BulldozerController classToTest = new BulldozerController(bulldozerMock, siteMock);
        classToTest.turnRight();
        verify(bulldozerMock).increaseCommandsCount();
        verify(bulldozerMock).turnRight();
    }

    @Test
    void moveTwoTimes() {
        ClearableBlock blockMock = mock(ClearableBlock.class);
        when(siteMock.move(anyObject())).thenReturn(blockMock);
        BulldozerController classToTest = new BulldozerController(bulldozerMock, siteMock);
        classToTest.move(2);

        verify(bulldozerMock).increaseCommandsCount();
        verify(blockMock, times(2)).clear(anyObject());
    }
}