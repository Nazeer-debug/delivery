import model.Package;
import service.PackageService;

import java.util.Scanner;

class CourierServiceApplication {
    public static void main(String[] args) {
        PackageService packageService = new PackageService();
        Scanner scanner = new Scanner(System.in);

        int baseDeliveryCost = scanner.nextInt();
        int noOfPackages = scanner.nextInt();

        for (int i = 0; i < noOfPackages; i++) {
            String id = scanner.next();
            int weight = scanner.nextInt();
            int distance = scanner.nextInt();
            String offerCode = scanner.next();
            packageService.add(new Package(id, weight, distance, offerCode));
        }
        packageService.print();
    }
}