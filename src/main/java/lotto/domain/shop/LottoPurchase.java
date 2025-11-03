package lotto.domain.shop;

import lotto.domain.lotto.LottoWallet;

public class LottoPurchase {

    private final int purchaseAmount;
    private final LottoWallet lottoWallet;

    public LottoPurchase(int purchaseAmount, LottoWallet lottoWallet) {
        this.purchaseAmount = purchaseAmount;
        this.lottoWallet = lottoWallet;
    }

    public LottoWallet getLottoWallet() {
        return lottoWallet;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
