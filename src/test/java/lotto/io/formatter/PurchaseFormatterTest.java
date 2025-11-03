package lotto.io.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoWallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseFormatterTest {

    PurchaseFormatter purchaseFormatter = new PurchaseFormatter();

    LottoPurchase lottoPurchase;

    @BeforeEach
    void setup() {
        int purchaseAmount = 1000;
        LottoWallet lottoWallet = new LottoWallet(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));

        lottoPurchase = new LottoPurchase(purchaseAmount, lottoWallet);
    }

    @Test
    void representPurchasedLottoCount() {
        String lottoCountRepresentation = purchaseFormatter.formatPurchaseQuantity(lottoPurchase);

        assertThat(lottoCountRepresentation).isEqualTo("1개를 구매했습니다.");
    }

    @Test
    void representationPurchasedLottoNumbers() {
        String lottoNumberRepresentation = purchaseFormatter.formatPurchasedLotto(lottoPurchase);

        assertThat(lottoNumberRepresentation).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}