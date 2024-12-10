package bridge.exception;

import bridge.enums.ErrorMessage;

public class CustomException extends RuntimeException {
    public CustomException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
