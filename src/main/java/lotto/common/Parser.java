package lotto.common;

public interface Parser<T, R> {

    R parse(T input);
}
