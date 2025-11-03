package lotto.domain.shop;

import lotto.common.Validator;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidRangeException;

public class AmountValidator implements Validator<Integer> {

    private static final int MINIMUM_PURCHASE_AMOUNT = 0;

    @Override
    public void validate(Integer money) {
        if (isLessThanMinimumPurchase(money)) {
            throw new InvalidRangeException(ErrorCode.PURCHASE_OUT_OF_RANGE);
        }
    }

    private boolean isLessThanMinimumPurchase(int money) {
        return money <= MINIMUM_PURCHASE_AMOUNT;
    }

}
