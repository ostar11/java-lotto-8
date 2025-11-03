package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("생성한 숫자는 1부터 45사이의 숫자이다.")
    @Test
    void numbersShouldBeRandomInRange() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        int startNumber = 1;
        int endNumber = 45;

        List<Integer> expectedNumbers = IntStream.range(startNumber, endNumber + 1).boxed().toList();

        assertThat(numbers).containsAnyElementsOf(expectedNumbers);
    }

    @DisplayName("생성한 숫자는 오름차순으로 정렬되어 있다.")
    @Test
    void numbersShouldBeSorted() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        assertThat(numbers).isSorted();
    }

    @DisplayName("생성한 숫자 중에 중복된 숫자는 없다.")
    @Test
    void numbersShouldBeUnique() {
        List<Integer> numbers = lottoNumberGenerator.generate();

        assertThat(numbers).doesNotHaveDuplicates();
    }

}