package lotto.domain.bonusNumber;

import lotto.exception.ErrorCode;
import lotto.exception.InvalidRangeException;

public class BonusNumberRule {

    private static final int MINIMUM_BONUS_NUMBER = 1;
    private static final int MAXIMUM_BONUS_NUMBER = 45;

    public static void validate(int number) {
        if (isOutOfRange(number)) {
            throw new InvalidRangeException(ErrorCode.BONUS_OUT_OF_RANGE);
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return number < MINIMUM_BONUS_NUMBER || number > MAXIMUM_BONUS_NUMBER;
    }

}
