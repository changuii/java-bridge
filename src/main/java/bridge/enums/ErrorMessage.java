package bridge.enums;

public enum ErrorMessage {

    BRIDGE_DISTANCE_INPUT_TEXT_NOT_VALID("다리의 길이는 숫자로 입력해야 합니다.");


    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
