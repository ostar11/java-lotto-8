package lotto.io.mapper;

import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;

public class LottoMapper {

    private static final String NUMBER_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";

    public static String mapLotto(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));
    }
}
