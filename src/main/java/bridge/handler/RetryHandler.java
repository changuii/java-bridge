package bridge.handler;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class RetryHandler {

    public <T> void retryUntilSuspendOrClear(final Consumer<T> logic, final BooleanSupplier suspend,
                                             final BooleanSupplier clear, final T data) {
        while (!(suspend.getAsBoolean() || clear.getAsBoolean())) {
            logic.accept(data);
        }
    }

    public <T> void retryUntilTrue(final Consumer<T> logic, final BooleanSupplier flag, final T data) {
        while (flag.getAsBoolean()) {
            logic.accept(data);
        }
    }
}
