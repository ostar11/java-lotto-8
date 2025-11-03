package lotto.exception;

public class InvalidFormatException extends IllegalArgumentException {

    public InvalidFormatException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
