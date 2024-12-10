package bridge.view;

import bridge.enums.OutputMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
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

    public void printGameResultIntroduce() {
        print(OutputMessage.GAME_RESULT_INTRODUCE);
    }

    public void printGameResultClear(final boolean gameClear) {
        print(OutputMessage.GAME_RESULT_CLEAR, formatGameClear(gameClear));
    }

    public void printGameResultTryCount(final int tryCount) {
        print(OutputMessage.GAME_TRY_COUNT, tryCount);
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
