package lotto.domain.lotto;

import java.util.stream.Stream;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위 안에 속하지 않으면 에외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideWrongLottoNumber")
    void numbersOutOfRangeCannotMakeLotto(List<Integer> wrongNumbers) {
        assertThatThrownBy(() -> new Lotto(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 성공")
    @ParameterizedTest
    @MethodSource("provideValidNumber")
    void createLotto(List<Integer> numbers) {
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @DisplayName("당첨번호와 매칭되는 숫자 개수 세기")
    @ParameterizedTest
    @MethodSource("provideWinningNumber")
    void countMatchedNumber(WinningNumber winningNumber, long expectedMatchCount) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        long matchCount = lotto.countMatching(winningNumber);

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @DisplayName("보너스 번호를 포함 여부")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void containsBonusNumber(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(number);

        assertThat(lotto.containsBonus(bonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWrongLottoNumber() {
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

    private static Stream<Arguments> provideWinningNumber() {
        return Stream.of(
                Arguments.arguments(WinningNumber.of(List.of(1, 2, 3, 4, 5, 6)), 6L),
                Arguments.arguments(WinningNumber.of(List.of(1, 2, 3, 4, 5, 12)), 5L),
                Arguments.arguments(WinningNumber.of(List.of(1, 2, 3, 4, 11, 12)), 4L),
                Arguments.arguments(WinningNumber.of(List.of(1, 2, 3, 10, 11, 12)), 3L),
                Arguments.arguments(WinningNumber.of(List.of(1, 2, 9, 10, 11, 12)), 2L),
                Arguments.arguments(WinningNumber.of(List.of(1, 8, 9, 10, 11, 12)), 1L),
                Arguments.arguments(WinningNumber.of(List.of(7, 8, 9, 10, 11, 12)), 0L)
        );
    }
}
