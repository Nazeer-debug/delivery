package model;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Vehicle {
    private final int maxSpeed;
    private final int maxLoad;
    private boolean isAvailable;
    private Float timeToReachSource;

    public Vehicle(int maxSpeed, int maxLoad) {
        this.maxSpeed = maxSpeed;
        this.maxLoad = maxLoad;
        this.isAvailable = true;
        this.timeToReachSource = 0.f;
    }

    public Map<String, Float> deliver(List<Package> packages) {
        if (packages == null || packages.isEmpty()) return new HashMap<>();

        this.isAvailable = false;
        Map<String, Float> deliveryRecord = new HashMap<>();

        for (Package p : packages) {
            float time = p.getDistance() / (float) this.maxSpeed;
            time += timeToReachSource;
            deliveryRecord.put(p.getId(), (float) (Math.floor(time * 100) / 100.f));
        }
        return deliveryRecord;
    }

    public void setTimeToReachSource(Float timeToReachSource) {
        this.timeToReachSource = timeToReachSource;
    }
}
