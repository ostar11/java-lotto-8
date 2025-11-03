package lotto.domain.bonusnumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.bonusNumber.BonusNumberValidator;
import lotto.domain.winningnumber.WinningNumber;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @DisplayName("당첨 번호에 속하는 번호는 보너스 번호는 검증이 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void throwExceptionWhenWinningNumberContainsBonusNumber(int number) {
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> bonusNumberValidator.validate(number, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.BONUS_DUPLICATE.getMessage());
    }

    @DisplayName("당첨 번호와 중복되지 않는 숫자는 검증이 성공한다.")
    @Test
    void validateSuccessWhenUsingNumberExceptWinningNumber() {
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));
        int number = 7;

        Assertions.assertDoesNotThrow(() -> bonusNumberValidator.validate(number, winningNumber));
    }
}