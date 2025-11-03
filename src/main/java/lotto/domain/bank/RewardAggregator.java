package lotto.domain.bank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.lotto.LottoReward;

public class RewardAggregator {

    public Map<LottoReward, Long> createTotalRewardStatistics(Map<LottoReward, Long> rewardCount) {
        Map<LottoReward, Long> totalRewardCount = new LinkedHashMap<>();

        Arrays.stream(LottoReward.values())
                .sorted(Comparator.comparing(LottoReward::getPrize))
                .forEach(lottoReward -> {
                    long count = rewardCount.getOrDefault(lottoReward, 0L);
                    totalRewardCount.put(lottoReward, count);
                });

        return totalRewardCount;
    }
}
