package lotto.domain.bonusNumber;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber of(int number) {
        BonusNumberRule.validate(number);
        return new BonusNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
