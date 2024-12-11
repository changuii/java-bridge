package bridge.mock;

import bridge.component.BridgeNumberGenerator;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class MockBridgeNumberGenerator implements BridgeNumberGenerator {
    private final Queue<Integer> mockNumbers;

    public MockBridgeNumberGenerator() {
        this.mockNumbers = new ArrayDeque<>();
    }

    public void additionNumber(final int num) {
        this.mockNumbers.offer(num);
    }

    public void addtionNumbers(final List<Integer> numbers) {
        this.mockNumbers.addAll(numbers);
    }

    @Override
    public int generate() {
        return mockNumbers.poll();
    }
}
