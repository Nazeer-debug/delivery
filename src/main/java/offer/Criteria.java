package offer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Criteria {
    private final int minDistance;
    private final int maxDistance;
    private final int minWeight;
    private final int maxWeight;
}
