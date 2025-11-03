package lotto.io.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.lotto.LottoReward;
import org.junit.jupiter.api.Test;

class RewardMapperTest {

    @Test
    void representRewardStatistics() {
        long count = 5L;
        Entry<LottoReward, Long> rewardCount = Map.entry(LottoReward.FIFTH, count);
        String expectedRepresentation = "3개 일치 (5,000원) - 5개";

        String representation = RewardMapper.mapRewardStatistics(rewardCount);

        assertThat(representation).isEqualTo(expectedRepresentation);
    }
}