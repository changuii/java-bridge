package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String SAFE = "O";
    private static final String FAIL = "X";
    private final List<String> passedRoad;
    private int location;
    private int retryCount;

    private User() {
        this.passedRoad = new ArrayList<>();
        this.location = 0;
        this.retryCount = 0;
    }

    public static User create() {
        return new User();
    }

    public String move(final List<String> bridge, final String moving) {
        if (bridge.get(location++).equals(moving)) {
            passedRoad.add(SAFE);
            return SAFE;
        }
        passedRoad.add(FAIL);
        return FAIL;
    }
}
