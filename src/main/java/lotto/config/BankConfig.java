package lotto.config;

import lotto.domain.bank.LottoBank;
import lotto.domain.bank.RewardAggregator;
import lotto.domain.bank.RewardCollector;

public class BankConfig {

    public LottoBank lottoBank() {
        return new LottoBank(rewardCollector(), rewardAggregator());
    }

    private RewardCollector rewardCollector() {
        return new RewardCollector();
    }

    private RewardAggregator rewardAggregator() {
        return new RewardAggregator();
    }
}
