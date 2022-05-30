package model;

import lombok.Getter;

@Getter
public class Package {
    private final String id;
    private final int weight;
    private final int distance;
    private final String offerCode;
    private final int baseDeliveryCost;
    private int cost;
    private int discount;
    private float deliveredTime;

    public Package(String id, int weight, int distance, String offerCode, int baseDeliveryCost) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
        this.baseDeliveryCost = baseDeliveryCost;
    }

    public int getCost() {
        final int costPerDistance = 5;
        final int costPerWeight = 10;

        int totalCost = 0;
        totalCost += baseDeliveryCost;
        totalCost += costPerDistance * this.distance;
        totalCost += costPerWeight * this.weight;

        return totalCost;
    }

    public void setDeliveredTime(float deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
