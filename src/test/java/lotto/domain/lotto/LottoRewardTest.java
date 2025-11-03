package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRewardTest {

    @ParameterizedTest
    @MethodSource("provideScoreAndReward")
    void findRewardFromScore(LottoScore lottoScore, LottoReward expectedLottoReward) {
        LottoReward reward = LottoReward.from(lottoScore);

        assertThat(reward).isEqualTo(expectedLottoReward);
    }

    @ParameterizedTest
    @MethodSource("provideUnrankedScore")
    void cannotFindRewardWithUnrankedScore(LottoScore lottoScore) {
        assertThatThrownBy(() -> LottoReward.from(lottoScore))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideScoreAndReward() {
        return Stream.of(
                Arguments.arguments(new LottoScore(6, false), LottoReward.FIRST),
                Arguments.arguments(new LottoScore(5, true), LottoReward.SECOND),
                Arguments.arguments(new LottoScore(5, false), LottoReward.THIRD),
                Arguments.arguments(new LottoScore(4, false), LottoReward.FOURTH),
                Arguments.arguments(new LottoScore(4, true), LottoReward.FOURTH),
                Arguments.arguments(new LottoScore(3, false), LottoReward.FIFTH),
                Arguments.arguments(new LottoScore(3, true), LottoReward.FIFTH)
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