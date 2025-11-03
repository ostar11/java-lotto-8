package lotto.application;

import lotto.domain.winningnumber.WinningNumber;
import lotto.domain.winningnumber.WinningNumberFactory;
import lotto.io.InputReader;

public class WinningNumberService {

    private final InputReader inputReader;
    private final WinningNumberFactory winningNumberFactory;

    public WinningNumberService(InputReader inputReader, WinningNumberFactory winningNumberFactory) {
        this.inputReader = inputReader;
        this.winningNumberFactory = winningNumberFactory;
    }

    public WinningNumber register() {
        String winningNumbersInput = inputReader.readWinningNumbers();
        return winningNumberFactory.build(winningNumbersInput);
    }
}
