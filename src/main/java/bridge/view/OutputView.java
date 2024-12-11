package bridge.view;

import bridge.dto.GameResultDto;
import bridge.dto.MapDto;
import bridge.enums.OutputMessage;
import bridge.exception.CustomException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final MapDto mapDto) {
        print(OutputMessage.BRIDGE_STATE_FORMAT,
                makeBridgeState(mapDto.getBridge(), mapDto.getPassedRoad(), OutputMessage.UP_ROAD));
        print(OutputMessage.BRIDGE_STATE_FORMAT,
                makeBridgeState(mapDto.getBridge(), mapDto.getPassedRoad(), OutputMessage.DOWN_ROAD));
        printLineBreak();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final MapDto mapDto, final GameResultDto gameResultDto) {
        printGameResultIntroduce();
        printMap(mapDto);
        printGameResultClear(gameResultDto.isClear());
        printGameResultTryCount(gameResultDto.getTryCount());
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

    public void printErrorMessage(final CustomException customException) {
        print(customException.getMessage());
    }

    private String makeBridgeState(final List<String> bridge, final List<String> passedRoad,
                                   final OutputMessage roadType) {
        return IntStream.range(0, passedRoad.size())
                .mapToObj(i -> bridgeAndRoadToState(bridge.get(i), passedRoad.get(i), roadType.toString()))
                .collect(Collectors.joining(OutputMessage.BRIDGE_STATE_DELIMITER.toString()));
    }

    private String bridgeAndRoadToState(final String nowBridge, final String nowRoad, final String roadType) {
        if (nowBridge.equals(roadType)) {
            if (nowRoad.equals("X")) {
                return format(OutputMessage.EMPTY_ROAD);
            }
            return format(OutputMessage.ROAD_STATE_FORMAT, nowRoad);
        }
        if (nowRoad.equals("X")) {
            return format(OutputMessage.ROAD_STATE_FORMAT, nowRoad);
        }
        return format(OutputMessage.EMPTY_ROAD);
    }

    private void printGameResultIntroduce() {
        print(OutputMessage.GAME_RESULT_INTRODUCE);
    }

    private void printGameResultClear(final boolean gameClear) {
        print(OutputMessage.GAME_RESULT_CLEAR, formatGameClear(gameClear));
    }

    private void printGameResultTryCount(final int tryCount) {
        print(OutputMessage.GAME_TRY_COUNT, tryCount);
    }

    private void printLineBreak() {
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

    private String format(final Object format, final Object... values) {
        return String.format(format.toString(), values);
    }
}
