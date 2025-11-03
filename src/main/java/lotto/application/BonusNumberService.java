package lotto.application;

import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.bonusNumber.BonusNumberFactory;
import lotto.domain.winningnumber.WinningNumber;
import lotto.io.InputReader;

public class BonusNumberService {

    private final InputReader inputReader;
    private final BonusNumberFactory bonusNumberFactory;

    public BonusNumberService(InputReader inputReader, BonusNumberFactory bonusNumberFactory) {
        this.inputReader = inputReader;
        this.bonusNumberFactory = bonusNumberFactory;
    }

    public BonusNumber register(WinningNumber winningNumber) {
        String bonusNumberInput = inputReader.readBonusNumber();
        return bonusNumberFactory.build(bonusNumberInput, winningNumber);
    }
}
