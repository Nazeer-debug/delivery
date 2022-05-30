package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OfferServiceTest {

    private final OfferService offerService;

    public OfferServiceTest() {
        super();
        this.offerService = new OfferService();
    }

    @Test
    void shouldReturnZeroDiscountIfOfferCodeIsNull() {
        int weight = 5;
        int distance = 5;
        String offerCode = null;

        int discount = offerService.getDiscount(distance, weight, offerCode);

        Assertions.assertEquals(0, discount);
    }

    @Test
    void shouldReturnZeroDiscountIfOfferCodeIsEmpty() {
        int weight = 5;
        int distance = 5;
        String offerCode = "";

        int discount = offerService.getDiscount(distance, weight, offerCode);

        Assertions.assertEquals(0, discount);
    }

    @Test
    public void shouldReturnZeroDiscountIfOfferIsInvalid() {
        int weight = 5;
        int distance = 5;
        String offerCode = "OFR001";

        int discount = offerService.getDiscount(distance, weight, offerCode);

        Assertions.assertEquals(0, discount);
    }

    @Test
    void shouldReturnTheDiscountOnTheValidOfferCode() {
        int weight = 10;
        int distance = 100;
        String offerCode = "OFR003";

        int discount = offerService.getDiscount(distance, weight, offerCode);

        Assertions.assertEquals(5, discount);
    }
}