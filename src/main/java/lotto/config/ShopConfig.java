package lotto.config;

import java.util.List;
import lotto.application.LottoShopService;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoNumberGenerator;
import lotto.domain.shop.AmountValidator;
import lotto.domain.shop.LottoShopStaff;
import lotto.domain.shop.PurchaseParser;
import lotto.domain.shop.PurchaseUnitValidator;
import lotto.domain.shop.PurchaseValidator;
import lotto.io.InputReader;

public class ShopConfig {

    public LottoShopService lottoShopService(InputReader inputReader) {
        return new LottoShopService(inputReader, purchaseParser(), lottoShopStaff());
    }

    private PurchaseParser purchaseParser() {
        return new PurchaseParser();
    }

    private LottoShopStaff lottoShopStaff() {
        return new LottoShopStaff(purchaseValidator(), lottoFactory());
    }

    private PurchaseValidator purchaseValidator() {
        return new PurchaseValidator(List.of(amountValidator(), purchaseUnitValidator()));
    }

    private AmountValidator amountValidator() {
        return new AmountValidator();
    }

    private PurchaseUnitValidator purchaseUnitValidator() {
        return new PurchaseUnitValidator();
    }

    private LottoFactory lottoFactory() {
        return new LottoFactory(lottoNumberGenerator());
    }

    private LottoNumberGenerator lottoNumberGenerator() {
        return new LottoNumberGenerator();
    }
}
