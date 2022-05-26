package service;

import model.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageService {
    private final List<Package> packages;
    private final OfferService offerService;
    private final PrintService printService;

    public PackageService() {
        this.packages = new ArrayList<>();
        this.offerService = new OfferService();
        this.printService = new PrintService();
    }

    public void add(Package p) {
        this.packages.add(p);
    }

    private int getDiscount(Package p) {
        int discount = offerService.getDiscount(p.getDistance(), p.getWeight(), p.getOfferCode());
        return getTotalCost(p) * discount / 100;
    }

    private int getTotalCost(Package p) {
        return p.getCost();
    }

    public void print() {
        for (Package p : packages) {
            printService.print(p.getId(), getDiscount(p), getTotalCost(p));
        }
    }
}
