package lotto.exception;

public enum ErrorCode {

    EMPTY_INPUT("null이거나 빈 입력값", "[ERROR] 입력값이 비어있습니다."),
    INVALID_PURCHASE_FORMAT("금액 파싱 실패", "[ERROR] 입력한 금액이 숫자가 아닙니다."),
    INVALID_BONUS_FORMAT("보너스 번호 파싱 실패", "[ERROR] 보너스 번호는 숫자이어야 합니다."),
    INVALID_WINNING_FORMAT("당첨 번호 파싱 실패", "[ERROR] 당첨 번호는 숫자이어야 합니다."),
    BONUS_OUT_OF_RANGE("보너스 번호 범위 검증 실패", "[ERROR] 보너스 번호가 범위 밖입니다."),
    LOTTO_OUT_OF_RANGE("로또 번호 범위 검증 실패", "[ERROR] 로또 번호가 범위 밖입니다."),
    WINNING_OUT_OF_RANGE("당첨 번호 범위 검증 실패", "[ERROR] 당첨번호가 숫자 범위에 속하지 않습니다."),
    PURCHASE_OUT_OF_RANGE("구매 금액 범위 검증 실패", "[ERROR] 구매 금액은 0원보다 커야 합니다."),
    BONUS_DUPLICATE("보너스 번호와 당첨 번호 중복", "[ERROR] 보너스 번호는 당첨 번호와 중복입니다."),
    LOTTO_DUPLICATE("로또 번호 중복", "[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    WINNING_DUPLICATE("당첨 번호 중복", "[ERROR] 당첨번호는 중복되지 않아야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("당첨 번호 개수 검증 실패", "[ERROR] 당첨번호는 6개로 구성되어야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호 개수 검증 실패", "[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_UNIT("구매 금액 단위가 다름", "[ERROR] 구매 금액은 1000원 단위만 가능합니다.");

    private final String description;
    private final String message;

    ErrorCode(String description, String message) {
        this.description = description;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
