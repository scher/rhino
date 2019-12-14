package com.bulldozer.reports;

import com.bulldozer.domain.bulldozer.IBulldozerController;
import com.bulldozer.domain.site.TraversableSite;

import java.util.Arrays;
import java.util.List;

public class SiteClearingReport implements Reportable {
    private static final String COMMUNICATION_MESSAGE = "communication overhead per command sent to bulldozer operator";
    private static final String FUEL_MESSAGE = "fuel";
    private static final String UNCLEARED_SQUARE_MESSAGE = "uncleared square at end of simulation";
    private static final String PROTECTED_TREE_DESTRUCTION_MESSAGE = "destruction of protected tree";
    private static final String DAMAGED_PAINT_MESSAGE = "repairing paint damage to bulldozer clearable tree";
    private static int COMMUNICATION_CREDIT = 1;
    private static int FUEL_CREDIT = 1;
    private static int UNCLEARED_SQUARE_CREDIT = 3;
    private static int PROTECTED_TREE_DESTRUCTION_CREDIT = 10;
    private static int DAMAGED_PAINT_CREDIT = 2;
    private IBulldozerController bulldozerController;
    private TraversableSite site;

    public SiteClearingReport(IBulldozerController bulldozerController, TraversableSite site) {
        this.bulldozerController = bulldozerController;
        this.site = site;
    }

    @Override
    public List<ReportItem> generateReport() {
        int commandsAmount = bulldozerController.getCommandsCount();
        int usedFuelAmount = bulldozerController.getUsedFuelAmount();
        int unclearedBlocksAmount = site.getUnclearedBlocksAmount();
        int protectedTreeDestroyedAmount = site.getProtectedTreeDestroyedAmount();
        int damagedPaintAmount = bulldozerController.getDamagedPaintAmount();

        int commandsCost = bulldozerController.getCommandsCount() * COMMUNICATION_CREDIT;
        int usedFuelCost = bulldozerController.getUsedFuelAmount() * FUEL_CREDIT;
        int unclearedBlocksCost = site.getUnclearedBlocksAmount() * UNCLEARED_SQUARE_CREDIT;
        int protectedTreeDestroyedCost = site.getProtectedTreeDestroyedAmount() * PROTECTED_TREE_DESTRUCTION_CREDIT;
        int damagedPaintCost = bulldozerController.getDamagedPaintAmount() * DAMAGED_PAINT_CREDIT;

        return Arrays.asList(
                new ReportItem(COMMUNICATION_MESSAGE, commandsAmount, commandsCost),
                new ReportItem(FUEL_MESSAGE, usedFuelAmount, usedFuelCost),
                new ReportItem(UNCLEARED_SQUARE_MESSAGE, unclearedBlocksAmount, unclearedBlocksCost),
                new ReportItem(PROTECTED_TREE_DESTRUCTION_MESSAGE, protectedTreeDestroyedAmount, protectedTreeDestroyedCost),
                new ReportItem(DAMAGED_PAINT_MESSAGE, damagedPaintAmount, damagedPaintCost)
        );
    }
}
