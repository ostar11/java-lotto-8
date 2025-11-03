package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoNumberGenerator;
import lotto.domain.shop.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopStaffTest {

    LottoShopStaff staff = new LottoShopStaff(
            new PurchaseValidator(List.of(new AmountValidator(), new PurchaseUnitValidator())),
            new LottoFactory(new LottoNumberGenerator()));

    @DisplayName("유효하지 않은 형식의 돈으로는 판매할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, -1000, 0, -1})
    void throwExceptionWhenSellingWithInvalidMoney(int money) {
        assertThatThrownBy(() -> staff.sell(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 성공")
    @Test
    void sellWithValidMoney() {
        int money = 5000;
        int expectedLottoCount = money / 1000;

        LottoPurchase lottoPurchase = staff.sell(money);

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        List<Lotto> lottos = lottoPurchase.getLottoWallet().getLottos();
        assertThat(purchaseAmount).isEqualTo(money);
        assertThat(lottos).hasSize(expectedLottoCount);
    }


}