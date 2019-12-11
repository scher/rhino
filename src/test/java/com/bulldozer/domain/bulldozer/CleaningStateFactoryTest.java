package com.bulldozer.domain.bulldozer;

import com.bulldozer.domain.site.SiteCleaner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class CleaningStateFactoryTest {

    @Test
    void initStoppingState() {
        Bulldozer bulldozerMock = mock(Bulldozer.class);
        BulldozerController controllerMock = mock(BulldozerController.class);
        SiteCleaner siteCleaner = CleaningStateFactory.initBulldozerState(1, bulldozerMock, controllerMock);
        Assertions.assertTrue(siteCleaner instanceof StoppedBulldozerState);
    }

    @Test
    void initMovingState() {
        Bulldozer bulldozerMock = mock(Bulldozer.class);
        BulldozerController controllerMock = mock(BulldozerController.class);
        SiteCleaner siteCleaner = CleaningStateFactory.initBulldozerState(2, bulldozerMock, controllerMock);
        Assertions.assertTrue(siteCleaner instanceof MovingBulldozerState);
    }
}