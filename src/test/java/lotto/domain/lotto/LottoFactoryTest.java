package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    LottoFactory lottoFactory = new LottoFactory(new LottoNumberGenerator());

    @DisplayName("지갑에는 투입한 개수만큼의 로또가 있어야 한다.")
    @Test
    void walletHasSameQuantityWithInputQuantity() {
        int lottoQuantity = 10;

        LottoWallet wallet = lottoFactory.build(lottoQuantity);

        List<Lotto> lottos = wallet.getLottos();
        assertThat(lottos).hasSize(lottoQuantity);
    }

    @DisplayName("각 로또는 6개의 숫자를 가진다.")
    @Test
    void eachLottoHasSixNumbers() {
        LottoWallet wallet = lottoFactory.build(5);
        int expectedSize = 6;

        for (Lotto lotto : wallet.getLottos()) {
            assertThat(lotto.getNumbers()).hasSize(expectedSize);
        }
    }

    @DisplayName("각 로또에서 중복되는 숫자는 없다.")
    @Test
    void eachLottoHasUniqueNumber() {
        LottoWallet wallet = lottoFactory.build(5);

        for (Lotto lotto : wallet.getLottos()) {
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        }
    }

    @DisplayName("각 로또의 숫자는 정렬되어 있다.")
    @Test
    void numbersAreSortedWithinEachLotto() {
        LottoWallet wallet = lottoFactory.build(5);

        for (Lotto lotto : wallet.getLottos()) {
            assertThat(lotto.getNumbers()).isSorted();
        }
    }

    @DisplayName("로또 번호는 모두 1부터 45사이의 숫자여야 한다.")
    @Test
    void numbersAreInValidRange() {
        LottoWallet wallet = lottoFactory.build(5);

        for (Lotto lotto : wallet.getLottos()) {
            assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        }
    }

}