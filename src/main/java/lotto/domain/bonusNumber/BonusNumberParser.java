package lotto.domain.bonusNumber;

import lotto.common.Parser;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidFormatException;

public class BonusNumberParser implements Parser<String, Integer> {

    @Override
    public Integer parse(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(ErrorCode.INVALID_BONUS_FORMAT);
        }
    }
}
