package bridge.enums;

public enum ErrorMessage {

    BRIDGE_DISTANCE_INPUT_TEXT_INVALID("다리의 길이는 숫자로 입력해야 합니다."),
    BRIDGE_DISTANCE_MORE_THAN_MIN("다리의 길이는 3 이상으로 입력해야 합니다."),
    BRIDGE_DISTANCE_LESS_THAN_MAX("다리의 길이는 20 이하로 입력해야 합니다."),

    TEXT_PARSE_INVALID("파싱하려는 문자가 잘못된 형태입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
