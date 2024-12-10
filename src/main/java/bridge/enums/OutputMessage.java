package bridge.enums;

public enum OutputMessage {

    BRIDGE_GAME_INTRODUCE("다리 건너기 게임을 시작합니다."),
    BRIDGE_DISTANCE_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    GAME_RESULT_INTRODUCE("최종 게임 결과");
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
