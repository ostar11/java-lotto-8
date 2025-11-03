package lotto.domain.bonusnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.bonusNumber.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("잘못된 값으로 보너스번호를 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void throwExceptionWhenCreatingBonusNumberWithinInvalidNumber(int number) {
        assertThatThrownBy(() -> BonusNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void successCreatingBonusNumberWithinValidNumber(int number) {
        BonusNumber bonusNumber = BonusNumber.of(number);

        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

}