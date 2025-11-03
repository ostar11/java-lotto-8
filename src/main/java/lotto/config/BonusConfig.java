package lotto.config;

import lotto.application.BonusNumberService;
import lotto.domain.bonusNumber.BonusNumberFactory;
import lotto.domain.bonusNumber.BonusNumberParser;
import lotto.domain.bonusNumber.BonusNumberValidator;
import lotto.io.InputReader;

public class BonusConfig {

    public BonusNumberService bonusNumberService(InputReader inputReader) {
        return new BonusNumberService(inputReader, bonusNumberFactory());
    }

    private BonusNumberFactory bonusNumberFactory() {
        return new BonusNumberFactory(bonusNumberParser(), bonusNumberValidator());
    }

    private BonusNumberParser bonusNumberParser() {
        return new BonusNumberParser();
    }

    private BonusNumberValidator bonusNumberValidator() {
        return new BonusNumberValidator();
    }
}
