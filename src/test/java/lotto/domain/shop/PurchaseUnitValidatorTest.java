package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseUnitValidatorTest {

    PurchaseUnitValidator purchaseUnitValidator = new PurchaseUnitValidator();

    @DisplayName("구매 금액이 1000원 단위가 아니면 검증이 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 500, 2800})
    void invalidMoneyUnitFailToValidate(int money) {
        assertThatThrownBy(() -> purchaseUnitValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_UNIT.getMessage());
    }

    @DisplayName("구매 금액이 1000원 단위면 검증 성공")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000})
    void thousandMoneyUnitSuccessToValidate(int money) {
        assertDoesNotThrow(() -> purchaseUnitValidator.validate(money));
    }
}