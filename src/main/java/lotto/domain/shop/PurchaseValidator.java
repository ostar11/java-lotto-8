package lotto.domain.shop;

import java.util.List;
import lotto.common.Validator;

public class PurchaseValidator {

    private final List<Validator<Integer>> validators;

    public PurchaseValidator(List<Validator<Integer>> validators) {
        this.validators = validators;
    }

    public void validate(int money) {
        validators.forEach(validator -> validator.validate(money));
    }

}
