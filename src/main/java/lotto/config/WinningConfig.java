package lotto.config;

import lotto.application.WinningNumberService;
import lotto.domain.winningnumber.WinningNumberFactory;
import lotto.domain.winningnumber.WinningNumberParser;
import lotto.io.InputReader;

public class WinningConfig {

    public WinningNumberService winningNumberService(InputReader inputReader) {
        return new WinningNumberService(inputReader, winningNumberFactory());
    }

    private WinningNumberFactory winningNumberFactory() {
        return new WinningNumberFactory(winningNumberParser());
    }

    private WinningNumberParser winningNumberParser() {
        return new WinningNumberParser();
    }
}
