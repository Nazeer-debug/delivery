package service;

import model.Package;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackageServiceTest {
    private final PackageService packageService;

    public PackageServiceTest() {
        this.packageService = new PackageService();
    }

    @Test
    public void shouldReturnNoMaximumWeightedPackagesIfPackagesAreEmpty() {

        List<Package> packages = packageService.getPackages(200);

        assertEquals(0, packages.size());
    }

    @Test
    void shouldReturnNoMaximumWeightedPackagesIfThereAreNoPackagesWithTargetWeight() {
        packageService.add("PKG01", 10, 10, "OFR001",100);

        List<Package> packages = packageService.getPackages(5);

        assertEquals(0, packages.size());
    }

    @Test
    void shouldReturnMaximumWeightedPackages() {
        packageService.add("PKG01", 1, 1, "OFR001",100);
        packageService.add("PKG02", 11, 2, "OFR002",100);
        packageService.add("PKG03", 5, 3, "OFR003",100);
        packageService.add("PKG04", 9, 4, "OFR004",100);
        packageService.add("PKG05", 3, 5, "OFR005",100);

        List<Package> packages = packageService.getPackages(10);

        assertEquals(3, packages.size());
        assertEquals("PKG01", packages.get(0).getId());
        assertEquals("PKG05", packages.get(1).getId());
        assertEquals("PKG03", packages.get(2).getId());
    }

    @Test
    void shouldReturnPackageWithLessDistanceWhenTwoPackagesWeightsAreSame() {
        packageService.add("PKG01", 120, 7, "OFR001",100);
        packageService.add("PKG02", 120, 6, "OFR002",100);
        packageService.add("PKG04", 1, 1, "OFR001",100);
        packageService.add("PKG05", 11, 2, "OFR002",100);

        List<Package> packages = packageService.getPackages(140);

        assertEquals(3, packages.size());
        assertEquals("PKG04", packages.get(0).getId());
        assertEquals("PKG05", packages.get(1).getId());
        assertEquals("PKG02", packages.get(2).getId());
    }
}