package lotto.domain.lotto;

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

class LottoRuleTest {

    @DisplayName("로또 번호는 6개가 아니면 예외가 발생한다.")
    @Test
    void lottoNumbersShouldBeValidCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> LottoRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateNumbersAreNotPermitted() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> LottoRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45사이에 속하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumberOutOfRange")
    void lottoNumbersShouldBeInValidRange(List<Integer> numbers) {
        assertThatThrownBy(() -> LottoRule.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 번호 규칙 통과")
    @ParameterizedTest
    @MethodSource("provideValidNumber")
    void passLottoNumberRule(List<Integer> numbers) {
        assertDoesNotThrow(() -> LottoRule.validate(numbers));
    }

    private static Stream<Arguments> provideLottoNumberOutOfRange() {
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