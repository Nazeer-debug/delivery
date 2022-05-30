package service;

import model.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.MockitoLogger;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class VehicleServiceTest {

    private final VehicleService vehicleService;
    private final PackageService packageService = Mockito.mock(PackageService.class);

    public VehicleServiceTest() {
        this.vehicleService = new VehicleService(new PackageService());
    }

    @Test
    void shouldReturnZeroDeliveryPackagesIfThereAreNoPackages() {
        vehicleService.add(3, 70, 200);

        vehicleService.deliver();

        List<Package> deliveredPackages = vehicleService.getDeliveredPackages();
        Assertions.assertEquals(0,deliveredPackages.size());
    }

    @Test
    void shouldReturnZeroDeliveredPackagesIfPackagesIsEmpty() {
        vehicleService.add(2,70,10);

        Package p1 = new Package("PKG01", 1, 1, "OFR001");
        Package p2 = new Package("PKG02", 11, 2, "OFR002");
        Package p3 = new Package("PKG03", 5, 3, "OFR003");
        Package p4 = new Package("PKG05", 3, 5, "OFR005");

        when(packageService.getPackages()).thenReturn(List.of(p1,p2,p3,p4));
        when(packageService.getPackages(10)).thenReturn(List.of(p1,p3,p4));

        vehicleService.deliver();
        List<Package> deliveredPackages = vehicleService.getDeliveredPackages();
        System.out.println(deliveredPackages);
    }
}