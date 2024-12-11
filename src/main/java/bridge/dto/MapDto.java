package bridge.dto;

import java.util.List;

public class MapDto {
    private final List<String> bridge;
    private final List<String> passedRoad;

    private MapDto(final List<String> bridge, final List<String> passedRoad) {
        this.bridge = bridge;
        this.passedRoad = passedRoad;
    }

    public static MapDto of(final List<String> bridge, final List<String> passedRoad) {
        return new MapDto(bridge, passedRoad);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getPassedRoad() {
        return passedRoad;
    }
}
