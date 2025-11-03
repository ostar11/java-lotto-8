package lotto.domain.lotto;

import java.util.List;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.winningnumber.WinningNumber;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<LottoScore> calculateScore(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return this.lottos.stream()
                .map(lotto -> {
                    long matchCount = lotto.countMatching(winningNumber);
                    boolean hasBonusNumber = lotto.containsBonus(bonusNumber);
                    return new LottoScore(matchCount, hasBonusNumber);
                })
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
