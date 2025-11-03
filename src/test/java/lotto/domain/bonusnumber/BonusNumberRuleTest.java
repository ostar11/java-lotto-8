package lotto.domain.bonusnumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.domain.bonusNumber.BonusNumberRule;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberRuleTest {

    @DisplayName("범위에 속하지 않는 숫자는 규칙을 위반한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void violateRuleWhenUsingNumberOutOfRange(int number) {
        assertThatThrownBy(() -> BonusNumberRule.validate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.BONUS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("범위 안의 숫자는 규칙을 통과한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void passRuleWhenUsingNumberInRange(int number) {
        assertDoesNotThrow(() -> BonusNumberRule.validate(number));
    }
}