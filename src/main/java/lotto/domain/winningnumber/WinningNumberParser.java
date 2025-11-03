package lotto.domain.winningnumber;

import java.util.Arrays;
import java.util.List;
import lotto.common.Parser;
import lotto.exception.ErrorCode;
import lotto.exception.InvalidFormatException;

public class WinningNumberParser implements Parser<String, List<Integer>> {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    @Override
    public List<Integer> parse(String winningNumbersInput) {
        try {
            return Arrays.stream(winningNumbersInput.split(WINNING_NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(ErrorCode.INVALID_WINNING_FORMAT);
        }
    }
}
