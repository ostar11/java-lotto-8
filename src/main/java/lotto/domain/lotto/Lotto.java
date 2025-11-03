package lotto.domain.lotto;

import java.util.List;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.winningnumber.WinningNumber;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoRule.validate(numbers);
        this.numbers = numbers;
    }

    public long countMatching(WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsBonus(BonusNumber bonusNumber) {
        int number = bonusNumber.getNumber();
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
