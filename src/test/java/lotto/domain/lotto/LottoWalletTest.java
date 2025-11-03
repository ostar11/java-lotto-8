package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @Test
    void evaluateLotto() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoWallet lottoWallet = new LottoWallet(lottos);

        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(7);

        long expectedMatchCount = 6L;
        boolean expectedBonusNumberCondition = false;

        // when
        List<LottoScore> lottoScores = lottoWallet.calculateScore(winningNumber, bonusNumber);

        // then
        assertThat(lottoScores).extracting(LottoScore::getMatchCount).contains(expectedMatchCount);
        assertThat(lottoScores).extracting(LottoScore::hasBonusNumber).contains(expectedBonusNumberCondition);
    }

}