package lotto.domain.bonusnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.bonusNumber.BonusNumberFactory;
import lotto.domain.bonusNumber.BonusNumberParser;
import lotto.domain.bonusNumber.BonusNumberValidator;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberFactoryTest {

    BonusNumberFactory bonusNumberFactory = new BonusNumberFactory(new BonusNumberParser(), new BonusNumberValidator());

    @DisplayName("유효하지 않은 번호는 보너스 번호로 등록할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", ",*:", "0", "46", "1"})
    void throwExceptionWhenInvalidBonusNumber(String bonusNumberInput) {
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> bonusNumberFactory.build(bonusNumberInput, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 등록 성공")
    @Test
    void registerBonusNumber() {
        String bonusNumberInput = "7";
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));
        int expectedBonusNumber = Integer.parseInt(bonusNumberInput);

        BonusNumber bonusNumber = assertDoesNotThrow(() -> bonusNumberFactory.build(bonusNumberInput, winningNumber));

        assertThat(bonusNumber.getNumber()).isEqualTo(expectedBonusNumber);
    }
}