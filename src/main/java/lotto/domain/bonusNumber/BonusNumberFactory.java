package lotto.domain.bonusNumber;

import lotto.domain.winningnumber.WinningNumber;

public class BonusNumberFactory {

    private final BonusNumberParser bonusNumberParser;
    private final BonusNumberValidator bonusNumberValidator;

    public BonusNumberFactory(BonusNumberParser bonusNumberParser, BonusNumberValidator bonusNumberValidator) {
        this.bonusNumberParser = bonusNumberParser;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public BonusNumber build(String bonusNumberInput, WinningNumber winningNumber) {
        int parsedNumber = bonusNumberParser.parse(bonusNumberInput);

        bonusNumberValidator.validate(parsedNumber, winningNumber);

        return BonusNumber.of(parsedNumber);
    }
}
