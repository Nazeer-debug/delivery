package offer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OfferCode {
    private final String code;
    private final int discount;
    private final Criteria criteria;
}
