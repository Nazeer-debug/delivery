package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackageTest {

    @Test
    void shouldReturnTotalCostZero() {
        Package p = new Package("PKG01", 0, 0, "OFR001",100);

        Assertions.assertEquals(100, p.getCost());
    }

    @Test
    void shouldReturnTotalCost() {
        Package p = new Package("PKG01", 5, 5, "OFR001",100);

        Assertions.assertEquals(175, p.getCost());
    }
}
