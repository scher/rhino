package com.bulldozer.reports;

public class ReportItem {
    private String message;
    private int quantity;
    private int cost;

    @Override
    public String toString() {
        return message + ": " + "quantity=" + quantity +
                ", cost=" + cost;
    }

    public ReportItem(String message, int quantity, int cost) {
        this.message = message;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getMessage() {
        return message;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }
}
