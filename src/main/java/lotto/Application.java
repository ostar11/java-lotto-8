package lotto;

import lotto.application.LottoApplication;
import lotto.config.ApplicationConfig;

public class Application {
    public static void main(String[] args) {
        LottoApplication lottoApplication = new ApplicationConfig().load();
        lottoApplication.run();
    }
}
