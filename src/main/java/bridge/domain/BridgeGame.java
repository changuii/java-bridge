package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String SAFE = "O";
    private static final String FAIL = "X";
    private static final int BRFORE_START = 0;
    private final List<String> bridge;
    private final List<String> passedRoad;
    private int retryCount;

    private BridgeGame(final List<String> bridge) {
        this.passedRoad = new ArrayList<>();
        this.bridge = bridge;
        retryCount = 0;
    }

    public static BridgeGame from(final List<String> bridge) {
        return new BridgeGame(bridge);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String moving) {
        if (bridge.get(getNextLocation()).equals(moving)) {
            passedRoad.add(SAFE);
            return;
        }
        passedRoad.add(FAIL);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isSuspend() {
        return getCurrentLocation() >= BRFORE_START && passedRoad.get(getCurrentLocation()).equals(FAIL);
    }

    public boolean isClear() {
        return passedRoad.size() == bridge.size() && passedRoad.get(getCurrentLocation()).equals(SAFE);
    }

    private int getCurrentLocation() {
        return passedRoad.size() - 1;
    }

    private int getNextLocation() {
        return passedRoad.size();
    }
}
