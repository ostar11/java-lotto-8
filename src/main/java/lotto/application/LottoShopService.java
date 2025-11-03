package lotto.application;

import lotto.domain.shop.LottoPurchase;
import lotto.domain.shop.LottoShopStaff;
import lotto.domain.shop.PurchaseParser;
import lotto.io.InputReader;

public class LottoShopService {

    private final InputReader inputReader;
    private final PurchaseParser purchaseParser;
    private final LottoShopStaff lottoShopStaff;

    public LottoShopService(InputReader inputReader, PurchaseParser purchaseParser, LottoShopStaff lottoShopStaff) {
        this.inputReader = inputReader;
        this.purchaseParser = purchaseParser;
        this.lottoShopStaff = lottoShopStaff;
    }

    public LottoPurchase purchaseLotto() {
        String purchaseInput = inputReader.readPurchase();
        int purchaseAmount = purchaseParser.parse(purchaseInput);

        return lottoShopStaff.sell(purchaseAmount);
    }

}
