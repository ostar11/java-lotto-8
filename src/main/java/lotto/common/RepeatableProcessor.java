package lotto.common;

import java.util.function.Supplier;
import lotto.io.ErrorWriter;

public class RepeatableProcessor<T> {

    public RepeatableProcessor() {
    }

    public T execute(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ErrorWriter.write(e.getMessage());
            }
        }
    }
}
