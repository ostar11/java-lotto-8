package lotto.config;

import lotto.application.BonusNumberService;
import lotto.application.LottoApplication;
import lotto.application.LottoShopService;
import lotto.application.WinningNumberService;
import lotto.domain.bank.LottoBank;
import lotto.io.InputReader;
import lotto.io.OutputWriter;

public class ApplicationConfig {

    private final IOConfig ioConfig = new IOConfig();

    public LottoApplication load() {
        OutputWriter outputWriter = getOutputWriter();
        InputReader inputReader = getInputReader();

        LottoShopService lottoShopService = createLottoShopService(inputReader);
        WinningNumberService winningNumberService = createWinningNumberService(inputReader);
        BonusNumberService bonusNumberService = createBonusNumberService(inputReader);
        LottoBank lottoBank = createLottoBank();

        return new LottoApplication
                (lottoShopService, winningNumberService, bonusNumberService, outputWriter, lottoBank);
    }

    private OutputWriter getOutputWriter() {
        return ioConfig.outputWriter();
    }

    private InputReader getInputReader() {
        return ioConfig.inputReader();
    }

    private LottoShopService createLottoShopService(InputReader inputReader) {
        ShopConfig shopConfig = new ShopConfig();
        return shopConfig.lottoShopService(inputReader);
    }

    private WinningNumberService createWinningNumberService(InputReader inputReader) {
        WinningConfig winningConfig = new WinningConfig();
        return winningConfig.winningNumberService(inputReader);
    }

    private BonusNumberService createBonusNumberService(InputReader inputReader) {
        BonusConfig bonusConfig = new BonusConfig();
        return bonusConfig.bonusNumberService(inputReader);
    }

    private LottoBank createLottoBank() {
        BankConfig bankConfig = new BankConfig();
        return bankConfig.lottoBank();
    }

}
