package lotto.domain.lotto;

import java.util.List;
import lotto.exception.DuplicationException;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidCountException;
import lotto.exception.InvalidRangeException;

public class LottoRule {

    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidCountException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != numbers.size()) {
            throw new DuplicationException(ErrorCode.LOTTO_DUPLICATE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < LOWER_LIMIT || number > UPPER_LIMIT);
        if (isOutOfRange) {
            throw new InvalidRangeException(ErrorCode.LOTTO_OUT_OF_RANGE);
        }
    }

}
