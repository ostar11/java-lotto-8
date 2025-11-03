package lotto.domain.bank;

import java.util.List;
import java.util.Map;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.LottoReward;
import lotto.domain.lotto.LottoScore;
import lotto.domain.lotto.LottoWallet;
import lotto.domain.winningnumber.WinningNumber;

public class LottoBank {

    private final RewardCollector rewardCollector;
    private final RewardAggregator rewardAggregator;

    public LottoBank(RewardCollector rewardCollector, RewardAggregator rewardAggregator) {
        this.rewardCollector = rewardCollector;
        this.rewardAggregator = rewardAggregator;
    }

    public LottoResult calculateResult(WinningNumber winningNumber, BonusNumber bonusNumber,
                                       LottoPurchase lottoPurchase) {
        LottoWallet wallet = lottoPurchase.getLottoWallet();
        List<LottoScore> lottoScores = wallet.calculateScore(winningNumber, bonusNumber);

        Map<LottoReward, Long> rewardCount = rewardCollector.collectRewardCount(lottoScores);

        Map<LottoReward, Long> rewardStatistics = rewardAggregator.createTotalRewardStatistics(rewardCount);

        return new LottoResult(rewardStatistics, lottoPurchase.getPurchaseAmount());
    }

}
