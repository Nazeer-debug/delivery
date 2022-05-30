package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackageTest {

    @Test
    void shouldReturnTotalCostZero() {
        Package p = new Package("PKG01", 0, 0, "OFR001");

        Assertions.assertEquals(0, p.getCost());
    }

    @Test
    void shouldReturnTotalCost() {
        Package p = new Package("PKG01", 5, 5, "OFR001");

        Assertions.assertEquals(75, p.getCost());
    }
}
