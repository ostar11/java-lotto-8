package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberFactoryTest {

    WinningNumberFactory winningNumberFactory = new WinningNumberFactory(new WinningNumberParser());

    @DisplayName("유효하지 않은 문자열은 당첨 번호를 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", ";,;*;", "1 , 2, 3 ", "1,1,2,3,4,5", "1,2,3,4,5", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void buildWinningNumberFailWithInvalidInput(String input) {
        assertThatThrownBy(() -> winningNumberFactory.build(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성 성공")
    @Test
    void buildWinningNumberSuccess() {
        String input = "1,20,30,43,44,45";
        List<Integer> expectedNumber = List.of(1, 20, 30, 43, 44, 45);

        WinningNumber winningNumber = winningNumberFactory.build(input);

        assertThat(winningNumber.getNumbers()).containsExactlyElementsOf(expectedNumber);
    }

}