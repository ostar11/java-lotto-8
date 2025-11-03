package lotto.domain.bonusNumber;

import lotto.domain.winningnumber.WinningNumber;
import lotto.exception.DuplicationException;
import lotto.exception.ErrorCode;

public class BonusNumberValidator {

    public void validate(int number, WinningNumber winningNumber) {
        if (winningNumber.contains(number)) {
            throw new DuplicationException(ErrorCode.BONUS_DUPLICATE);
        }
    }

}
