package lotto.domain.winningnumber;

import java.util.List;
import lotto.exception.DuplicationException;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidCountException;
import lotto.exception.InvalidRangeException;

public class WinningNumberRule {

    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 45;
    private static final int WINNING_NUMBER_COUNT = 6;

    public static void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (isInvalidCount(numbers)) {
            throw new InvalidCountException(ErrorCode.INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            throw new DuplicationException(ErrorCode.WINNING_DUPLICATE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean containsOutOfRangeNumber = numbers.stream().anyMatch(WinningNumberRule::isOutOfRange);
        if (containsOutOfRangeNumber) {
            throw new InvalidRangeException(ErrorCode.WINNING_OUT_OF_RANGE);
        }
    }

    private static boolean isInvalidCount(List<Integer> numbers) {
        return numbers.size() != WINNING_NUMBER_COUNT;
    }

    private static boolean isOutOfRange(Integer number) {
        return number < LOWER_LIMIT || number > UPPER_LIMIT;
    }
}
