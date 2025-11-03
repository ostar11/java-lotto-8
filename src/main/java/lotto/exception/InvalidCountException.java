package lotto.exception;

public class InvalidCountException extends IllegalArgumentException {

    public InvalidCountException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
