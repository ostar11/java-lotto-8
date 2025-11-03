package lotto.io.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoMapperTest {

    @Test
    void representLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String expectedRepresentation = "[1, 2, 3, 4, 5, 6]";

        String representation = LottoMapper.mapLotto(lotto);

        assertThat(representation).isEqualTo(expectedRepresentation);
    }

}