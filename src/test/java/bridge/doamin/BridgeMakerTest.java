package bridge.doamin;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeMaker;
import bridge.mock.MockBridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker;
    private final MockBridgeNumberGenerator mockBridgeNumberGenerator;

    public BridgeMakerTest() {
        this.mockBridgeNumberGenerator = new MockBridgeNumberGenerator();
        this.bridgeMaker = new BridgeMaker(mockBridgeNumberGenerator);
    }

    @Test
    void 값을_올바로_UD_로_변환하여_만드는지_테스트(){
        mockBridgeNumberGenerator.addtionNumbers(List.of(1, 0, 1, 0, 0, 1));
        List<String> expectedBridge = List.of("U", "D", "U", "D", "D", "U");

        List<String> actualBridge = bridgeMaker.makeBridge(6);

        assertThat(actualBridge).isEqualTo(expectedBridge);
    }

}
