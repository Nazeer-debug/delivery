package service;

import offer.Criteria;
import offer.OfferCode;

import java.util.ArrayList;
import java.util.List;

public class OfferService {

    private final List<OfferCode> offerCodes;

    public OfferService() {
        this.offerCodes = new ArrayList<>();
        init(offerCodes);
    }

    private void init(List<OfferCode> offerCodes) {
        offerCodes.add(new OfferCode("OFR001", 10, new Criteria(0, 200, 70, 200)));
        offerCodes.add(new OfferCode("OFR002", 7, new Criteria(50, 150, 100, 250)));
        offerCodes.add(new OfferCode("OFR003", 5, new Criteria(50, 250, 10, 150)));
    }

    public int getDiscount(int distance, int weight, String appliedOfferCode) {
        if (isValidOfferCode(distance, weight, appliedOfferCode)) {
            for (OfferCode offerCode : offerCodes) {
                if (offerCode.getCode().equals(appliedOfferCode)) {
                    return offerCode.getDiscount();
                }
            }
        }
        return 0;
    }

    private boolean isValidOfferCode(int distance, int weight, String appliedOfferCode) {
        if (appliedOfferCode == null || appliedOfferCode.isEmpty()) return false;
        for (OfferCode offerCode : offerCodes) {
            if (offerCode.getCode().equals(appliedOfferCode)) {
                Criteria criteria = offerCode.getCriteria();
                return isValidDistance(distance, criteria) && isValidWeight(weight, criteria);
            }
        }
        return false;
    }

    private boolean isValidWeight(int weight, Criteria criteria) {
        return weight >= criteria.getMinWeight() && weight <= criteria.getMaxWeight();
    }

    private boolean isValidDistance(int distance, Criteria criteria) {
        return distance >= criteria.getMinDistance() && distance <= criteria.getMaxDistance();
    }

}
