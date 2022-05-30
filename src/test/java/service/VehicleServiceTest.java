package service;

import model.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VehicleServiceTest {

    private final VehicleService vehicleService;
    private final PackageService packageService = mock(PackageService.class);

    public VehicleServiceTest() {
        this.vehicleService = new VehicleService(packageService);
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

        Package p1 = new Package("PKG01", 1, 1, "OFR001",100);
        Package p2 = new Package("PKG02", 11, 2, "OFR002",100);
        Package p3 = new Package("PKG03", 5, 3, "OFR003",100);
        Package p4 = new Package("PKG05", 3, 5, "OFR005",100);

        when(packageService.getPackages()).thenReturn(Arrays.asList(p1,p2,p3,p4));
        when(packageService.getPackages(10)).thenReturn(Arrays.asList(p1,p3,p4));

        //vehicleService.deliver();
    }
}