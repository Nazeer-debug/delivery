import model.Package;
import service.PackageService;
import service.PrintService;
import service.VehicleService;

import java.util.List;
import java.util.Scanner;

class CourierServiceApplication {
    public static void main(String[] args) {
        PackageService packageService = new PackageService();
        VehicleService vehicleService = new VehicleService(packageService);
        PrintService printService = new PrintService();
        Scanner scanner = new Scanner(System.in);

        int baseDeliveryCost = scanner.nextInt();
        int noOfPackages = scanner.nextInt();

        for (int i = 0; i < noOfPackages; i++) {
            String id = scanner.next();
            int weight = scanner.nextInt();
            int distance = scanner.nextInt();
            String offerCode = scanner.next();
            packageService.add(id, weight, distance, offerCode,baseDeliveryCost);
        }

        int noOfVehicles = scanner.nextInt();
        int maxSpeed = scanner.nextInt();
        int maxLoad = scanner.nextInt();
        vehicleService.add(noOfVehicles, maxSpeed, maxLoad);
        vehicleService.deliver();
        List<Package> deliveredPackages = vehicleService.getDeliveredPackages();
        printService.print(deliveredPackages);

    }
}