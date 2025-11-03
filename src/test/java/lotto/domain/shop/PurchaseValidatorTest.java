package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseValidatorTest {

    PurchaseValidator purchaseValidator = new PurchaseValidator(
            List.of(new AmountValidator(), new PurchaseUnitValidator()));

    @DisplayName("금액이 1000원 단위가 아니면 검증 실패")
    @ParameterizedTest
    @ValueSource(ints = {100, 10, 1003})
    void invalidMoneyUnitCannotPass(int money) {
        assertThatThrownBy(() -> purchaseValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 범위에 속하지 않으면 검증 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -1})
    void moneyOutOfRangeCannotPass(int money) {
        assertThatThrownBy(() -> purchaseValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 양수고 1000원 단위면 검증 성공")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000, 5000})
    void validationMoneySuccess(int money) {
        assertDoesNotThrow(() -> purchaseValidator.validate(money));
    }
}