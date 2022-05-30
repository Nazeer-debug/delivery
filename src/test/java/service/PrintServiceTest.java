package service;

import model.Package;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class PrintServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintService printService;

    public PrintServiceTest() {
        this.printService = new PrintService();
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintThePackageDetails() {
        Package p1 = new Package("PKG01", 5, 5, "OFR002",100);
        Package p2 = new Package("PKG02", 5, 5, "OFR002",100);

        List<Package> packages = new ArrayList<>(List.of(p1, p2));

        printService.print(packages);

        Assertions.assertEquals("PKG01 0 175 0.0\n" + "PKG02 0 175 0.0\n", outContent.toString());

    }
}