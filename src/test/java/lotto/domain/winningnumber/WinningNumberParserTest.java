package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberParserTest {

    WinningNumberParser winningNumberParser = new WinningNumberParser();

    @DisplayName("문자열은 숫자와 콤마 이외의 문자를 포함하면 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", ";,;*;", "1 , 2, 3 "})
    void inputShouldContainsOnlyNumberAndDelimiter(String input) {
        assertThatThrownBy(() -> winningNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_FORMAT.getMessage());
    }

    @DisplayName("숫자와 콤마로 이루어진 문자열 파싱은 성공한다.")
    @Test
    void parseSuccessWhenUsingNumberAndCommaDelimiter() {
        String input = "1,20,30,50";
        List<Integer> expectedNumber = List.of(1, 20, 30, 50);

        List<Integer> parsedNumber = winningNumberParser.parse(input);

        assertThat(parsedNumber).isSorted();
        assertThat(parsedNumber).containsExactlyElementsOf(expectedNumber);
    }

}