package lotto.domain.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.LottoReward;
import lotto.domain.lotto.LottoWallet;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.Test;

class LottoBankTest {

    LottoBank lottoBank = new LottoBank(new RewardCollector(), new RewardAggregator());

    @Test
    void collectRewardResultByPurchase() {
        // given
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );
        LottoWallet lottoWallet = new LottoWallet(lottos);
        LottoPurchase lottoPurchase = new LottoPurchase(10000, lottoWallet);

        // when
        LottoResult lottoResult = lottoBank.calculateResult(winningNumber, bonusNumber, lottoPurchase);

        // then
        Map<LottoReward, Long> rewardStatistics = lottoResult.getRewardStatistics();
        assertThat(rewardStatistics).hasSize(5)
                .containsEntry(LottoReward.FIRST, 0L)
                .containsEntry(LottoReward.SECOND, 1L)
                .containsEntry(LottoReward.THIRD, 0L)
                .containsEntry(LottoReward.FOURTH, 0L)
                .containsEntry(LottoReward.FIFTH, 1L);
    }
}