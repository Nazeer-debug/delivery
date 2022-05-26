package service;

public class PrintService {

    public void print(String id, int discount, int totalCost) {
        System.out.printf("%s %d %d%n", id, discount, totalCost);
    }
}
