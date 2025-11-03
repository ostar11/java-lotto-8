package lotto.exception;

public class InvalidUnitException extends IllegalArgumentException {

    public InvalidUnitException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
