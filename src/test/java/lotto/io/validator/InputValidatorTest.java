package lotto.io.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void emptyStringThrowsException(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.EMPTY_INPUT.getMessage());
    }

    @Test
    void validateSuccessWhenInputIsNotBlank() {
        String input = "abcde";
        assertDoesNotThrow(() -> InputValidator.validate(input));
    }
}