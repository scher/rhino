package com.bulldozer.reports;

import com.bulldozer.domain.bulldozer.IBulldozerController;
import com.bulldozer.domain.site.TraversableSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SiteClearingReportTest {

    private SiteClearingReport classToTest;
    private IBulldozerController bulldozerMock;
    private TraversableSite siteMock;

    @BeforeEach
    void setup() {
        bulldozerMock = mock(IBulldozerController.class);
        siteMock = mock(TraversableSite.class);
        classToTest = new SiteClearingReport(bulldozerMock, siteMock);
    }

    @Test
    void generateReport() {
        int amount = 5;
        when(bulldozerMock.getCommandsCount()).thenReturn(amount);
        when(bulldozerMock.getUsedFuelAmount()).thenReturn(amount);
        when(siteMock.getUnclearedBlocksAmount()).thenReturn(amount);
        when(siteMock.getProtectedTreeDestroyedAmount()).thenReturn(amount);
        when(bulldozerMock.getDamagedPaintAmount()).thenReturn(amount);

        List<ReportItem> reportItems = classToTest.generateReport();

        Assertions.assertEquals(reportItems.get(0).getQuantity(), amount);
        Assertions.assertEquals(reportItems.get(0).getCost(), amount);

        Assertions.assertEquals(reportItems.get(1).getQuantity(), amount);
        Assertions.assertEquals(reportItems.get(1).getCost(), amount);

        Assertions.assertEquals(reportItems.get(2).getQuantity(), amount);
        Assertions.assertEquals(reportItems.get(2).getCost(), 15);

        Assertions.assertEquals(reportItems.get(3).getQuantity(), amount);
        Assertions.assertEquals(reportItems.get(3).getCost(), 50);

        Assertions.assertEquals(reportItems.get(4).getQuantity(), amount);
        Assertions.assertEquals(reportItems.get(4).getCost(), 10);
    }
}