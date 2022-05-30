package model;

import lombok.Getter;
import constants.*;

import static constants.Constants.COST_PER_DISTANCE;
import static constants.Constants.COST_PER_WEIGHT;

@Getter
public class Package {
    private final String id;
    private final int weight;
    private final int distance;
    private final String offerCode;
    private int cost;
    private int discount;
    private float deliveredTime;

    public Package(String id, int weight, int distance, String offerCode) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
    }

    public int getCost() {
        final int baseDeliveryCost = 100;

        int totalCost = 0;
        totalCost += baseDeliveryCost;
        totalCost += COST_PER_DISTANCE * this.distance;
        totalCost += COST_PER_WEIGHT * this.weight;

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
