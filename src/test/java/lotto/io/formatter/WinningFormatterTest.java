package lotto.io.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.LottoReward;
import org.junit.jupiter.api.Test;

class WinningFormatterTest {

    WinningFormatter winningFormatter = new WinningFormatter();

    @Test
    void representRewardStatistics() {
        // given
        Map<LottoReward, Long> rewardCount = new LinkedHashMap<>();
        rewardCount.put(LottoReward.FOURTH, 4L);
        int purchaseAmount = 4000;

        LottoResult lottoResult = new LottoResult(rewardCount, purchaseAmount);

        // when
        String statisticsRepresentation = winningFormatter.formatStatistics(lottoResult);

        // then
        assertThat(statisticsRepresentation).isEqualTo("4개 일치 (50,000원) - 4개");
    }

    @Test
    void representEarningRate() {
        double earningRate = 12.38;

        String earningRateRepresentation = winningFormatter.formatEarningRate(earningRate);

        assertThat(earningRateRepresentation).isEqualTo("총 수익률은 12.4%입니다.");
    }
}