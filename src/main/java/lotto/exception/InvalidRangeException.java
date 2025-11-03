package lotto.exception;

public class InvalidRangeException extends IllegalArgumentException {

    public InvalidRangeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
