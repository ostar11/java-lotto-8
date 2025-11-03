package lotto.domain.lotto;

import java.util.Map;

public class LottoResult {

    private final Map<LottoReward, Long> rewardStatistics;
    private final int purchaseAmount;

    public LottoResult(Map<LottoReward, Long> rewardStatistics, int purchaseAmount) {
        this.rewardStatistics = rewardStatistics;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateEarningRate() {
        double totalPrize = rewardStatistics.entrySet().stream()
                .mapToDouble(entry -> {
                    LottoReward lottoReward = entry.getKey();
                    Long rewardCount = entry.getValue();

                    return lottoReward.getPrize() * rewardCount;
                })
                .sum();

        return totalPrize * 100 / purchaseAmount;
    }

    public Map<LottoReward, Long> getRewardStatistics() {
        return rewardStatistics;
    }
}
