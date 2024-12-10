package bridge.view.input;

import bridge.enums.ErrorMessage;
import bridge.exception.CustomException;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String BRIDGE_DISTANCE_INPUT_PATTERN_REGEX = "^[0-9]*$";
    private static final String MOVE_INPUT_PATTERN_REGEX = "^[UD]$";
    private static final Pattern BRIDGE_DISTANCE_INPUT_PATTERN = Pattern.compile(BRIDGE_DISTANCE_INPUT_PATTERN_REGEX);
    private static final Pattern MOVE_INPUT_PATTERN = Pattern.compile(MOVE_INPUT_PATTERN_REGEX);
    private static final int BRIDGE_DISTANCE_MIN = 3;
    private static final int BRIDGE_DISTANCE_MAX = 20;

    public void validateBridgeDistanceText(final String bridgeDistanceText) {
        if (!BRIDGE_DISTANCE_INPUT_PATTERN.matcher(bridgeDistanceText).matches()) {
            throw new CustomException(ErrorMessage.BRIDGE_DISTANCE_INPUT_TEXT_INVALID);
        }
    }

    public void validateBridgeDistance(final int distance) {
        validateBridgeDistanceMoreThanMin(distance);
        validateBridgeDistanceLessThanMax(distance);
    }

    public void validateMoveText(final String moveText) {
        if (!MOVE_INPUT_PATTERN.matcher(moveText).matches()) {
            throw new CustomException(ErrorMessage.MOVE_INPUT_TEXT_INVALID);
        }
    }


    private void validateBridgeDistanceMoreThanMin(final int distance) {
        if (distance < BRIDGE_DISTANCE_MIN) {
            throw new CustomException(ErrorMessage.BRIDGE_DISTANCE_MORE_THAN_MIN);
        }
    }

    private void validateBridgeDistanceLessThanMax(final int distance) {
        if (distance > BRIDGE_DISTANCE_MAX) {
            throw new CustomException(ErrorMessage.BRIDGE_DISTANCE_LESS_THAN_MAX);
        }
    }
}
