package lotto.domain.winningnumber;

import java.util.List;

public class WinningNumberFactory {

    private final WinningNumberParser winningNumberParser;

    public WinningNumberFactory(WinningNumberParser winningNumberParser) {
        this.winningNumberParser = winningNumberParser;
    }

    public WinningNumber build(String winningNumbersInput) {
        List<Integer> numbers = winningNumberParser.parse(winningNumbersInput);
        return WinningNumber.of(numbers);
    }
}
