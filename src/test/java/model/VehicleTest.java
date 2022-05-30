package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleTest {
    private final Vehicle vehicle;

    public VehicleTest() {
        this.vehicle = new Vehicle(70, 200);
    }

    @Test
    void shouldReturnEmptyDeliveryRecordIfPackagesAreEmpty() {
        List<Package> packages = new ArrayList<>();

        Map<String, Float> deliverRecord = vehicle.deliver(packages);

        Assertions.assertEquals(0, deliverRecord.size());
    }

    @Test
    void shouldReturnEmptyDeliveryRecordIfPackagesAreNull() {
        Map<String, Float> deliverRecord = vehicle.deliver(null);

        Assertions.assertEquals(0, deliverRecord.size());
    }

    @Test
    void shouldReturnDeliveryRecordForPackages() {
        Package p1 = new Package("PKG01", 1, 1, "OFR001",100);
        Package p2 = new Package("PKG02", 11, 2, "OFR002",100);

        Map<String, Float> deliveredPackages = vehicle.deliver(List.of(p1, p2));

        Assertions.assertEquals(2, deliveredPackages.size());
        Assertions.assertEquals(0.01f, deliveredPackages.get(p1.getId()));
        Assertions.assertEquals(0.02f, deliveredPackages.get(p2.getId()));

    }
}
