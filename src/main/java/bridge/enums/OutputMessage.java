package bridge.enums;

public enum OutputMessage {

    BRIDGE_GAME_INTRODUCE("다리 건너기 게임을 시작합니다.");
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
