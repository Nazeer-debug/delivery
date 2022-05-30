package service;

import model.Package;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PackageService {
    private final List<Package> packages;
    private final OfferService offerService;

    public PackageService() {
        this.packages = new ArrayList<>();
        this.offerService = new OfferService();
    }

    public void add(String id, int weight, int distance, String offerCode, int baseDeliveryCost) {
        this.packages.add(getPackage(id, weight, distance, offerCode, baseDeliveryCost));
    }

    private Package getPackage(String id, int weight, int distance, String offerCode, int baseDeliveryCost) {
        Package p = new Package(id, weight, distance, offerCode, baseDeliveryCost);
        p.setDiscount(getDiscount(p));
        p.setCost(getTotalCost(p) - p.getDiscount());
        return p;
    }

    private int getDiscount(Package p) {
        int discount = offerService.getDiscount(p.getDistance(), p.getWeight(), p.getOfferCode());
        return getTotalCost(p) * discount / 100;
    }

    private int getTotalCost(Package p) {
        return p.getCost();
    }

    public List<Package> getPackages() {
        return packages;
    }

    public List<Package> getPackages(int weight) {

        packages.sort(Comparator.comparing(Package::getWeight).thenComparing(Package::getDistance));

        int totalWeight = 0;
        List<Package> maxPackages = new ArrayList<>();
        for (Package p : packages) {
            if (totalWeight + p.getWeight() > weight) break;
            else {
                maxPackages.add(p);
                totalWeight += p.getWeight();
            }
        }
        int maxWeight = totalWeight;
        List<Package> maximumWeightedPackages = new ArrayList<>(maxPackages);
        for (int j = 0; j < maxPackages.size(); j++) {
            List<Package> temp = new ArrayList<>(maxPackages);
            for (int i = maxPackages.size(); i < packages.size(); i++) {
                temp.set(j, packages.get(i));
                int sum = temp.stream().mapToInt(Package::getWeight).sum();
                if (sum <= weight) {
                    if (sum > maxWeight) {
                        maxWeight = sum;
                        maximumWeightedPackages = new ArrayList<>(temp);
                    }
                }
            }
        }
        return maximumWeightedPackages;
    }

    public void remove(Package p) {
        packages.removeIf(pack -> pack.getId().equals(p.getId()));
    }
}
