package lotto.domain.bonusnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.bonusNumber.BonusNumberParser;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberParserTest {

    BonusNumberParser bonusNumberParser = new BonusNumberParser();

    @DisplayName("보너스 번호 입력이 숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "a123d", "*1234*", "1,2,3"})
    void inputShouldBeNumberFormat(String bonusNumberInput) {
        assertThatThrownBy(() -> bonusNumberParser.parse(bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_BONUS_FORMAT.getMessage());
    }

    @DisplayName("보너스 번호가 숫자 형식이면 파싱이 성공한다.")
    @Test
    void numberFormatInputCanBeParsed() {
        String bonusNumberInput = "40";
        int expectedBonusNumber = Integer.parseInt(bonusNumberInput);

        Integer parsedNumber = bonusNumberParser.parse(bonusNumberInput);

        assertThat(parsedNumber).isEqualTo(expectedBonusNumber);
    }
}