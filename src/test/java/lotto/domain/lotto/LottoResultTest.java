package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    LottoResult result;
    int purchaseAmount;

    @BeforeEach
    void setup() {
        Map<LottoReward, Long> rewardStatistics = new LinkedHashMap<>();
        rewardStatistics.put(LottoReward.FIFTH, 3L);
        rewardStatistics.put(LottoReward.FOURTH, 2L);
        rewardStatistics.put(LottoReward.THIRD, 2L);

        purchaseAmount = 10000;

        result = new LottoResult(rewardStatistics, purchaseAmount);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        // given
        Map<LottoReward, Long> rewardCount = result.getRewardStatistics();
        Long fifthCount = rewardCount.get(LottoReward.FIFTH);
        Long fourthCount = rewardCount.get(LottoReward.FOURTH);
        Long thirdCount = rewardCount.get(LottoReward.THIRD);

        long totalFifthPrize = LottoReward.FIFTH.getPrize() * fifthCount;
        long totalFourthPrize = LottoReward.FOURTH.getPrize() * fourthCount;
        long totalThirdPrize = LottoReward.THIRD.getPrize() * thirdCount;

        double expectedRate = (double) (totalThirdPrize + totalFourthPrize + totalFifthPrize) * 100 / purchaseAmount;

        // when
        double earningRate = result.calculateEarningRate();

        // then
        Assertions.assertThat(earningRate).isEqualTo(expectedRate);
    }
}