package lotto.domain.bank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoReward;
import lotto.domain.lotto.LottoScore;

public class RewardCollector {

    public Map<LottoReward, Long> collectRewardCount(List<LottoScore> lottoScores) {
        return lottoScores.stream()
                .filter(LottoRank::isRanked)
                .collect(Collectors.groupingBy(
                        LottoReward::from,
                        Collectors.counting()
                ));
    }
}
