package lotto.exception;

public class DuplicationException extends IllegalArgumentException {

    public DuplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
