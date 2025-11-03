package lotto.domain.shop;

import lotto.common.Validator;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidUnitException;

public class PurchaseUnitValidator implements Validator<Integer> {

    private static final int LOTTO_PRICE = 1000;

    @Override
    public void validate(Integer money) {
        if (isInvalidUnit(money)) {
            throw new InvalidUnitException(ErrorCode.INVALID_PURCHASE_UNIT);
        }
    }

    private boolean isInvalidUnit(int money) {
        return money % LOTTO_PRICE != 0;
    }

}
