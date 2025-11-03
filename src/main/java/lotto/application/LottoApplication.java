package lotto.application;

import lotto.common.RepeatableProcessor;
import lotto.domain.bank.LottoBank;
import lotto.domain.bonusNumber.BonusNumber;
import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoResult;
import lotto.domain.winningnumber.WinningNumber;
import lotto.io.OutputWriter;

public class LottoApplication {

    private final LottoShopService lottoShopService;
    private final WinningNumberService winningNumberService;
    private final BonusNumberService bonusNumberService;
    private final OutputWriter outputWriter;
    private final LottoBank lottoBank;

    public LottoApplication(LottoShopService lottoShopService, WinningNumberService winningNumberService,
                            BonusNumberService bonusNumberService, OutputWriter outputWriter, LottoBank lottoBank) {
        this.lottoShopService = lottoShopService;
        this.winningNumberService = winningNumberService;
        this.bonusNumberService = bonusNumberService;
        this.outputWriter = outputWriter;
        this.lottoBank = lottoBank;
    }

    public void run() {
        LottoPurchase purchase = new RepeatableProcessor<LottoPurchase>().execute(lottoShopService::purchaseLotto);
        outputWriter.writePurchase(purchase);

        WinningNumber winningNumber = new RepeatableProcessor<WinningNumber>().execute(winningNumberService::register);
        BonusNumber bonusNumber = new RepeatableProcessor<BonusNumber>().execute(() ->
                bonusNumberService.register(winningNumber));

        LottoResult lottoResult = lottoBank.calculateResult(winningNumber, bonusNumber, purchase);
        outputWriter.writeResult(lottoResult);
    }

}
