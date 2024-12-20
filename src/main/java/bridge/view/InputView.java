package bridge.view;

import bridge.view.input.InputParser;
import bridge.view.input.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputView(final InputValidator inputValidator, final InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        inputValidator.validateBridgeDistanceText(input);
        int distance = inputParser.parseInt(input);
        inputValidator.validateBridgeDistance(distance);
        return distance;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        inputValidator.validateMoveText(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String input = Console.readLine();
        inputValidator.validateSuspendText(input);
        return inputParser.parseSuspend(input);
    }
}
