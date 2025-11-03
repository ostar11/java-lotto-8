package lotto.exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
