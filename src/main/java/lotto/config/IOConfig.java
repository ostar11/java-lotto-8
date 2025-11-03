package lotto.config;

import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.io.formatter.PurchaseFormatter;
import lotto.io.formatter.WinningFormatter;

public class IOConfig {

    public InputReader inputReader() {
        return new InputReader();
    }

    public OutputWriter outputWriter() {
        return new OutputWriter(purchaseFormatter(), winningFormatter());
    }

    private PurchaseFormatter purchaseFormatter() {
        return new PurchaseFormatter();
    }

    private WinningFormatter winningFormatter() {
        return new WinningFormatter();
    }
}
