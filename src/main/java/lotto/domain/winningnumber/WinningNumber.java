package lotto.domain.winningnumber;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumber of(List<Integer> numbers) {
        WinningNumberRule.validate(numbers);
        return new WinningNumber(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
