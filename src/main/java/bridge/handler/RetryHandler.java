package bridge.handler;

import bridge.exception.CustomException;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryHandler {

    public <T> void retryUntilSuspendOrClear(final Consumer<T> logic, final BooleanSupplier suspend,
                                             final BooleanSupplier clear, final T data) {
        while (!(suspend.getAsBoolean() || clear.getAsBoolean())) {
            logic.accept(data);
        }
    }

    public <T> T retryUntilNotException(final Supplier<T> logic, final Consumer<CustomException> exceptionCallback) {
        while (true) {
            try {
                return logic.get();
            } catch (CustomException e) {
                exceptionCallback.accept(e);
            }
        }
    }
}
