package service;

import model.Package;
import model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class VehicleService {

    private final List<Vehicle> vehicles;
    private final PackageService packageService;
    private final List<Package> deliveredPackages;

    public VehicleService(PackageService packageService) {
        vehicles = new ArrayList<>();
        this.packageService = packageService;
        this.deliveredPackages = new ArrayList<>();
    }

    public void add(int noOfVehicles, int maxSpeed, int maxLoad) {
        for (int i = 0; i < noOfVehicles; i++) {
            Vehicle vehicle = new Vehicle(maxSpeed, maxLoad);
            vehicles.add(vehicle);
        }
    }

    public void deliver() {
        while (!packageService.getPackages().isEmpty()) {
            Vehicle vehicle = getAvailable();
            List<Package> packages = loadPackages(vehicle);
            Map<String, Float> deliveryRecord = vehicle.deliver(packages);
            vehicle.setTimeToReachSource(vehicle.getTimeToReachSource() + 2 * getTotalDuration(deliveryRecord));
            updateDeliveryTime(deliveryRecord);
        }
    }

    private float getTotalDuration(Map<String, Float> delivery) {
        float totalDuration = 0.f;
        for (Map.Entry entry : delivery.entrySet()) {
            totalDuration = Math.max(totalDuration, (Float) entry.getValue());
        }
        return totalDuration;
    }

    private void updateDeliveryTime(Map<String, Float> delivery) {
        for (Map.Entry entry : delivery.entrySet()) {
            for (Package p : deliveredPackages) {
                if (p.getId().equals(entry.getKey())) {
                    p.setDeliveredTime((Float) entry.getValue());
                }
            }
        }
    }


    private Vehicle getAvailable() {
        float min = Float.MAX_VALUE;
        Vehicle available = null;
        for (Vehicle vehicle : vehicles) {
            if (Float.compare(min, vehicle.getTimeToReachSource()) == 1) {
                available = vehicle;
                min = vehicle.getTimeToReachSource();
            }
        }
        return available;
    }


    private List<Package> loadPackages(Vehicle vehicle) {
        List<Package> packages = packageService.getPackages(vehicle.getMaxLoad());
        deliveredPackages.addAll(packages);
        for (Package p : packages) {
            packageService.remove(p);
        }
        return packages;
    }

    public List<Package> getDeliveredPackages() {
        deliveredPackages.sort(new Comparator<Package>() {
            @Override
            public int compare(Package p1, Package p2) {
                return p1.getId().compareTo(p2.getId());
            }
        });
        return deliveredPackages;
    }
}
