package bridge.view.input;

import bridge.enums.ErrorMessage;
import bridge.exception.CustomException;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String BRIDGE_DISTANCE_INPUT_PATTERN_REGEX = "^[0-9]*$";
    private static final Pattern BRIDGE_DISTANCE_INPUT_PATTERN = Pattern.compile(BRIDGE_DISTANCE_INPUT_PATTERN_REGEX);

    public void validateBridgeDistanceText(final String bridgeDistanceText) {
        if (!BRIDGE_DISTANCE_INPUT_PATTERN.matcher(bridgeDistanceText).matches()) {
            throw new CustomException(ErrorMessage.BRIDGE_DISTANCE_INPUT_TEXT_NOT_VALID);
        }
    }
}
