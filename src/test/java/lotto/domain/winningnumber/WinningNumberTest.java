package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @DisplayName("당첨 번호는 보너스 번호를 포함한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void containsBonusNumberInWinningNumber(int bonusNumber) {
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningNumber.contains(bonusNumber)).isTrue();
    }

    @DisplayName("당첨 번호는 보너스 번호를 포함하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10})
    void doesNotContainsBonusNumberInWinningNumber(int bonusNumber) {
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningNumber.contains(bonusNumber)).isFalse();
    }

    @DisplayName("당첨 번호가 규칙에 위배되면 생성되지 않는다.")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void winningNumbersShouldBeInValidRange(List<Integer> numbers) {
        assertThatThrownBy(() -> WinningNumber.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성 성공")
    @ParameterizedTest
    @MethodSource("provideValidNumber")
    void generateWinningNumberSuccess(List<Integer> numbers) {
        WinningNumber winningNumber = assertDoesNotThrow(() -> WinningNumber.of(numbers));

        assertThat(winningNumber.getNumbers()).containsExactlyInAnyOrderElementsOf(numbers);
    }

    private static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 45)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 5)),
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