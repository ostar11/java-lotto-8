package lotto.domain.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.lotto.LottoReward;
import org.junit.jupiter.api.Test;

class RewardAggregatorTest {

    RewardAggregator aggregator = new RewardAggregator();

    @Test
    void collectAllRewardCountByMatchedScore() {
        Map<LottoReward, Long> rewardCount = new LinkedHashMap<>();
        rewardCount.put(LottoReward.THIRD, 2L);
        rewardCount.put(LottoReward.FOURTH, 1L);

        Map<LottoReward, Long> expectedRewardStatistics = new LinkedHashMap<>();
        expectedRewardStatistics.put(LottoReward.FIFTH, 0L);
        expectedRewardStatistics.put(LottoReward.FOURTH, 1L);
        expectedRewardStatistics.put(LottoReward.THIRD, 2L);
        expectedRewardStatistics.put(LottoReward.SECOND, 0L);
        expectedRewardStatistics.put(LottoReward.FIRST, 0L);

        Map<LottoReward, Long> totalRewardStatistics = aggregator.createTotalRewardStatistics(rewardCount);

        assertThat(totalRewardStatistics).containsExactlyEntriesOf(expectedRewardStatistics);
    }
}