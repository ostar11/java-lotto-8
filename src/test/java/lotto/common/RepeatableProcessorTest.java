package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class RepeatableProcessorTest {

    @Test
    void doesNotRepeatWhenExceptionIsNotThrow() {
        Supplier<Integer> supplier = () -> 1;

        Integer result = new RepeatableProcessor<Integer>().execute(supplier);

        assertThat(result).isEqualTo(1);
    }

}