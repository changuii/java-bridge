package bridge.dto;

public class GameResultDto {
    private final boolean isClear;
    private final int tryCount;

    private GameResultDto(final boolean isClear, final int tryCount) {
        this.isClear = isClear;
        this.tryCount = tryCount;
    }

    public static GameResultDto of(final boolean isClear, final int tryCount) {
        return new GameResultDto(isClear, tryCount);
    }

    public boolean isClear() {
        return isClear;
    }

    public int getTryCount() {
        return tryCount;
    }
}
