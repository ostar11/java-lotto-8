package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberRuleTest {

    @DisplayName("당첨 번호는 6개가 아니면 예외가 발생한다.")
    @Test
    void winningNumbersShouldBeValidCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> WinningNumberRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateWinningNumbersIsNotPermitted() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> WinningNumberRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WINNING_DUPLICATE.getMessage());
    }

    @DisplayName("당첨 번호가 1부터 45사이에 속하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideWinningNumberOutOfRange")
    void winningNumbersShouldBeInValidRange(List<Integer> numbers) {
        assertThatThrownBy(() -> WinningNumberRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WINNING_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호 규칙 통과")
    @ParameterizedTest
    @MethodSource("provideValidNumber")
    void passWinningNumberRule(List<Integer> numbers) {
        assertDoesNotThrow(() -> WinningNumberRule.validate(numbers));
    }

    private static Stream<Arguments> provideWinningNumberOutOfRange() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 45, 46)),
                Arguments.arguments(List.of(0, 1, 2, 3, 4, 45))
        );
    }

    private static Stream<Arguments> provideValidNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45)),
                Arguments.arguments(List.of(1, 2, 3, 20, 44, 45))
        );
    }
}