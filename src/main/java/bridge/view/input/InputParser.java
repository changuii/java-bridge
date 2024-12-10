package bridge.view.input;

import bridge.enums.ErrorMessage;
import bridge.exception.CustomException;

public class InputParser {
    private static final String MOVE_UP = "U";
    private static final String SUSPEND_RESTART = "R";

    public int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.TEXT_PARSE_INVALID);
        }
    }

    public boolean parseMove(final String input) {
        return MOVE_UP.equals(input);
    }

    public boolean parseSuspend(final String input) {
        return SUSPEND_RESTART.equals(input);
    }
}
