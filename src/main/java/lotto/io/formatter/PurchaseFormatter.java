package lotto.io.formatter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoWallet;
import lotto.io.mapper.LottoMapper;

public class PurchaseFormatter {

    public String formatPurchaseQuantity(LottoPurchase lottoPurchase) {
        LottoWallet lottoWallet = lottoPurchase.getLottoWallet();
        return String.format("%d개를 구매했습니다.", lottoWallet.count());
    }

    public String formatPurchasedLotto(LottoPurchase lottoPurchase) {
        List<Lotto> lottos = lottoPurchase.getLottoWallet().getLottos();
        return lottos.stream()
                .map(LottoMapper::mapLotto)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
