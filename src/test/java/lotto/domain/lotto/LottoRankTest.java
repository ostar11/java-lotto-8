package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("로또 점수를 기반으로 등수를 계산한다.")
    @ParameterizedTest
    @MethodSource("provideScoreAndRank")
    void findFromLottoScore(LottoScore lottoScore, LottoRank expectedRank) {
        LottoRank rank = LottoRank.from(lottoScore);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @DisplayName("유효하지 않은 로또 점수는 등수가 없다.")
    @ParameterizedTest
    @MethodSource("provideUnrankedScore")
    void cannotFindRankFromInvalidScore(LottoScore lottoScore) {
        Assertions.assertThatThrownBy(() -> LottoRank.from(lottoScore))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 일치하는 점수가 없습니다.");
    }

    @DisplayName("점수에 해당하는 등수가 존재한다.")
    @Test
    void scoresIsInRank() {
        LottoScore lottoScore = new LottoScore(3, false);

        boolean isRanked = LottoRank.isRanked(lottoScore);

        assertThat(isRanked).isTrue();
    }

    @DisplayName("점수에 해당하는 등수가 존재하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideUnrankedScore")
    void scoresIsNotInRank() {
        LottoScore lottoScore = new LottoScore(2, false);

        boolean isRanked = LottoRank.isRanked(lottoScore);

        assertThat(isRanked).isFalse();
    }

    private static Stream<Arguments> provideScoreAndRank() {
        return Stream.of(
                Arguments.arguments(new LottoScore(6, false), LottoRank.FIRST),
                Arguments.arguments(new LottoScore(5, true), LottoRank.SECOND),
                Arguments.arguments(new LottoScore(5, false), LottoRank.THIRD),
                Arguments.arguments(new LottoScore(4, false), LottoRank.FOURTH),
                Arguments.arguments(new LottoScore(4, true), LottoRank.FOURTH),
                Arguments.arguments(new LottoScore(3, false), LottoRank.FIFTH),
                Arguments.arguments(new LottoScore(3, true), LottoRank.FIFTH)
        );
    }

    private static Stream<Arguments> provideUnrankedScore() {
        return Stream.of(
                Arguments.arguments(new LottoScore(2, true)),
                Arguments.arguments(new LottoScore(2, false)),
                Arguments.arguments(new LottoScore(1, true)),
                Arguments.arguments(new LottoScore(1, false)),
                Arguments.arguments(new LottoScore(0, true)),
                Arguments.arguments(new LottoScore(0, false))
        );
    }

}