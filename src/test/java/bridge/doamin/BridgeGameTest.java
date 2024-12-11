package bridge.doamin;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.mock.MockBridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private static final String SAFE = "O";
    private static final String FAIL = "X";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private final BridgeMaker bridgeMaker;
    private final MockBridgeNumberGenerator mockBridgeNumberGenerator;

    public BridgeGameTest() {
        mockBridgeNumberGenerator = new MockBridgeNumberGenerator();
        this.bridgeMaker = new BridgeMaker(mockBridgeNumberGenerator);
    }

    @Test
    void 이동했을때_이동한_칸이_이동할수있다면_SAFE_아니라면_FAIL을_담는다() {
        BridgeGame bridgeGame = createBridgeGame(List.of(1, 0));
        List<String> expectedPassedRoad = List.of(SAFE, FAIL);

        bridgeGame.move(UP);
        bridgeGame.move(UP);
        List<String> actualPassedRoad = bridgeGame.getPassedRoad();

        assertThat(actualPassedRoad).isEqualTo(expectedPassedRoad);
    }

    @Test
    void 사용자가_게임을_재시도하면_이를_카운트한다() {
        BridgeGame bridgeGame = createBridgeGame(List.of(1, 0));
        int expectedRetryCount = 2;

        bridgeGame.retry();
        int actualRetryCount = bridgeGame.getRetryCount();

        assertThat(actualRetryCount).isEqualTo(expectedRetryCount);
    }

    @Test
    void 사용자의_위치가_다리를_벗어나면_성공_테스트() {
        BridgeGame bridgeGame = createBridgeGame(List.of(1));

        bridgeGame.move(UP);
        boolean actualClear = bridgeGame.isClear();

        assertThat(actualClear).isTrue();
    }

    @Test
    void 사용자의_위치가_지나갈_수_없는_위치라면_중단_테스트() {
        BridgeGame bridgeGame = createBridgeGame(List.of(1));

        bridgeGame.move(DOWN);
        boolean actualSuspend = bridgeGame.isSuspend();

        assertThat(actualSuspend).isTrue();
    }


    private BridgeGame createBridgeGame(final List<Integer> bridgeNumbers) {
        mockBridgeNumberGenerator.addtionNumbers(bridgeNumbers);
        return BridgeGame.from(bridgeMaker.makeBridge(bridgeNumbers.size()));
    }

}
