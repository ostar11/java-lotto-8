package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountValidatorTest {

    AmountValidator amountValidator = new AmountValidator();

    @DisplayName("구매 금액이 0원 이하면 검증이 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, -10000})
    void negativeMoneyIsInvalid(int money) {
        assertThatThrownBy(() -> amountValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PURCHASE_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("구매 금액이 0원보다 크면 검증이 성공한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 1000, 10000})
    void positiveMoneyIsValid(int money) {
        assertDoesNotThrow(() -> amountValidator.validate(money));
    }

}