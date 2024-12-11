package bridge.view;

import bridge.enums.OutputMessage;
import bridge.exception.CustomException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String ROAD_STATE_FORMAT = " %s ";
    private static final String BRIDGE_STATE_FORMAT = "[%s]";
    private static final String UP_ROAD = "U";
    private static final String DOWN_ROAD = "D";
    private static final String EMPTY_ROAD = "   ";
    private static final String BRIDGE_STATE_DELIEMETER = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final List<String> bridge, final List<String> passedRoad) {
        print(BRIDGE_STATE_FORMAT, makeBridgeState(bridge, passedRoad, UP_ROAD));
        print(BRIDGE_STATE_FORMAT, makeBridgeState(bridge, passedRoad, DOWN_ROAD));
    }

    private String makeBridgeState(final List<String> bridge, final List<String> passedRoad, final String roadType) {
        return IntStream.range(0, passedRoad.size())
                .mapToObj(i -> bridgeAndRoadToState(bridge.get(i), passedRoad.get(i), roadType))
                .collect(Collectors.joining(BRIDGE_STATE_DELIEMETER));
    }

    private String bridgeAndRoadToState(final String nowBridge, final String nowRoad, final String roadType) {
        if (nowBridge.equals(roadType)) {
            if (nowRoad.equals("X")) {
                return EMPTY_ROAD;
            }
            return format(ROAD_STATE_FORMAT, nowRoad);
        }
        if (nowRoad.equals("X")) {
            return format(ROAD_STATE_FORMAT, nowRoad);
        }
        return EMPTY_ROAD;
    }

    private String format(final String format, final Object values) {
        return String.format(format, values);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printIntroduce() {
        print(OutputMessage.BRIDGE_GAME_INTRODUCE);
    }

    public void printBridgeDistanceInput() {
        print(OutputMessage.BRIDGE_DISTANCE_INPUT);
    }

    public void printMoveInput() {
        print(OutputMessage.MOVE_INPUT);
    }

    public void printRetryInput() {
        print(OutputMessage.RETRY_INPUT);
    }

    public void printGameResultIntroduce() {
        print(OutputMessage.GAME_RESULT_INTRODUCE);
    }

    public void printGameResultClear(final boolean gameClear) {
        print(OutputMessage.GAME_RESULT_CLEAR, formatGameClear(gameClear));
    }

    public void printGameResultTryCount(final int tryCount) {
        print(OutputMessage.GAME_TRY_COUNT, tryCount);
    }

    public void printErrorMessage(final CustomException customException) {
        print(customException.getMessage());
    }

    public void printLineBreak() {
        System.out.print(System.lineSeparator());
    }

    private OutputMessage formatGameClear(final boolean gameClear) {
        if (gameClear) {
            return OutputMessage.GAME_SUCCESS;
        }
        return OutputMessage.GAME_FAIL;
    }

    private void print(Object message, Object... values) {
        System.out.println(String.format(message.toString(), values));
    }
}
