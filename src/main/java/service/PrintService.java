package service;

import model.Package;

import java.util.List;

public class PrintService {

    public void print(List<Package> packages) {
        for (Package p : packages) {
            System.out.println(p.getId() + " " + p.getDiscount() + " " + p.getCost() + " " + p.getDeliveredTime());
        }
    }

}
