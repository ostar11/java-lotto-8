package lotto.domain.lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoWallet build(int totalQuantity) {
        List<Lotto> lottos = IntStream.range(0, totalQuantity)
                .mapToObj(quantity -> {
                    List<Integer> randomNumbers = lottoNumberGenerator.generate();
                    return new Lotto(randomNumbers);
                })
                .toList();

        return new LottoWallet(lottos);
    }

}
