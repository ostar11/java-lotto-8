package lotto.domain.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.LottoReward;
import lotto.domain.lotto.LottoScore;
import org.junit.jupiter.api.Test;

class RewardCollectorTest {

    RewardCollector rewardCollector = new RewardCollector();

    @Test
    void collectRewardCountByMatchedScore() {
        List<LottoScore> lottoScores = List.of(
                new LottoScore(3, false),
                new LottoScore(3, true),
                new LottoScore(2, true),
                new LottoScore(1, true)
        );

        Map<LottoReward, Long> rewardCount = rewardCollector.collectRewardCount(lottoScores);

        assertThat(rewardCount).containsEntry(LottoReward.FIFTH, 2L);
    }
}