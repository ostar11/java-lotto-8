package lotto.io.validator;

import java.util.Objects;
import lotto.exception.EmptyInputException;
import lotto.exception.ErrorCode;

public class InputValidator {

    public static void validate(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new EmptyInputException(ErrorCode.EMPTY_INPUT);
        }
    }
}
