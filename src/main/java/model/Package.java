package model;

import lombok.Getter;

@Getter
public class Package {
    private final String id;
    private final int weight;
    private final int distance;
    private final String offerCode;
    private int cost;

    public Package(String id, int weight, int distance, String offerCode) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
    }

    public int getCost() {
        final int baseDeliveryCost = 100;
        final int costPerWeight = 10;
        final int costPerDistance = 5;

        int totalCost = 0;
        totalCost += baseDeliveryCost;
        totalCost += costPerDistance * this.distance;
        totalCost += costPerWeight * this.weight;

        return totalCost;
    }
}
