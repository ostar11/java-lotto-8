package lotto.domain.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseParserTest {

    PurchaseParser purchaseParser = new PurchaseParser();

    @DisplayName("구매 금액이 숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "a123d", "*1234*"})
    void inputShouldBeNumberFormat(String purchaseAmountInput) {
        assertThatThrownBy(() -> purchaseParser.parse(purchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_PURCHASE_FORMAT.getMessage());
    }

    @DisplayName("구매 금액이 숫자 형식이면 파싱이 성공한다.")
    @Test
    void numberFormatInputCanBeParsed() {
        String purchaseAmountInput = "1234";
        int expectedPurchaseAmount = 1234;

        Integer purchaseAmount = purchaseParser.parse(purchaseAmountInput);

        assertThat(purchaseAmount).isEqualTo(expectedPurchaseAmount);
    }
}