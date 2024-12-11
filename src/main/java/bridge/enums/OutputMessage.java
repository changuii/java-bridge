package bridge.enums;

public enum OutputMessage {

    BRIDGE_GAME_INTRODUCE("다리 건너기 게임을 시작합니다."),
    BRIDGE_DISTANCE_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    GAME_RESULT_INTRODUCE("최종 게임 결과"),
    GAME_RESULT_CLEAR("게임 성공 여부: %s"),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    GAME_TRY_COUNT("총 시도한 횟수: %d"),

    ROAD_STATE_FORMAT(" %s "),
    BRIDGE_STATE_FORMAT("[%s]"),
    UP_ROAD("U"),
    DOWN_ROAD("D"),
    EMPTY_ROAD("   "),
    BRIDGE_STATE_DELIMITER("|");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
