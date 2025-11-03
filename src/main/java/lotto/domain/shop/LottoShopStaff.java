package lotto.domain.shop;

import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoWallet;

public class LottoShopStaff {

    private static final int LOTTO_PRICE = 1000;

    private final PurchaseValidator purchaseValidator;
    private final LottoFactory lottoFactory;

    public LottoShopStaff(PurchaseValidator purchaseValidator, LottoFactory lottoFactory) {
        this.purchaseValidator = purchaseValidator;
        this.lottoFactory = lottoFactory;
    }

    public LottoPurchase sell(int money) {
        purchaseValidator.validate(money);

        int quantity = calculateLottoQuantity(money);
        LottoWallet wallet = lottoFactory.build(quantity);

        return new LottoPurchase(money, wallet);
    }

    private int calculateLottoQuantity(int money) {
        return money / LOTTO_PRICE;
    }
}
