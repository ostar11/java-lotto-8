package lotto.io;

import lotto.domain.shop.LottoPurchase;
import lotto.domain.lotto.LottoResult;
import lotto.io.formatter.PurchaseFormatter;
import lotto.io.formatter.WinningFormatter;

public class OutputWriter {

    private final PurchaseFormatter purchaseFormatter;
    private final WinningFormatter winningFormatter;

    public OutputWriter(PurchaseFormatter purchaseFormatter, WinningFormatter winningFormatter) {
        this.purchaseFormatter = purchaseFormatter;
        this.winningFormatter = winningFormatter;
    }

    public void writePurchase(LottoPurchase purchase) {
        writeLottoQuantity(purchase);
        writeLottoNumbers(purchase);
    }

    public void writeResult(LottoResult lottoResult) {
        writeRewardStatistics(lottoResult);
        writeEarningRate(lottoResult);
    }

    private void writeLottoQuantity(LottoPurchase lottoPurchase) {
        String lottoQuantity = purchaseFormatter.formatPurchaseQuantity(lottoPurchase);
        System.out.println(lottoQuantity);
    }

    private void writeLottoNumbers(LottoPurchase purchase) {
        String lottoRepresentation = purchaseFormatter.formatPurchasedLotto(purchase);
        System.out.println(lottoRepresentation);
    }

    private void writeRewardStatistics(LottoResult lottoResult) {
        String statistics = winningFormatter.formatStatistics(lottoResult);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
    }

    private void writeEarningRate(LottoResult lottoResult) {
        double earningRate = lottoResult.calculateEarningRate();
        String earningRateAnnouncement = winningFormatter.formatEarningRate(earningRate);
        System.out.println(earningRateAnnouncement);
    }
}
