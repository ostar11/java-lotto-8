package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.validator.InputValidator;

public class InputReader {

    private static final String PURCHASE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchase() {
        System.out.println(PURCHASE_GUIDE_MESSAGE);
        String purchaseAmount = Console.readLine();
        InputValidator.validate(purchaseAmount);
        return purchaseAmount;
    }

    public String readWinningNumbers() {
        System.out.println(WINNING_NUMBER_GUIDE_MESSAGE);
        String winningNumbers = Console.readLine();
        InputValidator.validate(winningNumbers);
        return winningNumbers;
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_GUIDE_MESSAGE);
        String bonusNumber = Console.readLine();
        InputValidator.validate(bonusNumber);
        return bonusNumber;
    }

}
