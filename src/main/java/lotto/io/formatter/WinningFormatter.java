package lotto.io.formatter;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.LottoReward;
import lotto.io.mapper.RewardMapper;

public class WinningFormatter {

    public String formatStatistics(LottoResult lottoResult) {
        Map<LottoReward, Long> rewardStatistics = lottoResult.getRewardStatistics();

        return rewardStatistics.entrySet().stream()
                .map(RewardMapper::mapRewardStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String formatEarningRate(double earningRate) {
        return String.format("총 수익률은 %.1f%%입니다.", earningRate);
    }

}
