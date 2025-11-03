package lotto.domain.shop;

import lotto.common.Parser;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidFormatException;

public class PurchaseParser implements Parser<String, Integer> {

    @Override
    public Integer parse(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(ErrorCode.INVALID_PURCHASE_FORMAT);
        }
    }
}
