package lotto.io.mapper;

import java.text.DecimalFormat;
import java.util.Map.Entry;
import lotto.domain.lotto.LottoReward;

public class RewardMapper {

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static String mapRewardStatistics(Entry<LottoReward, Long> entry) {
        LottoReward reward = entry.getKey();
        String description = reward.getDescription();
        long prize = reward.getPrize();

        String formattedPrize = decimalFormat.format(prize);

        Long count = entry.getValue();

        return String.format("%s (%s원) - %d개", description, formattedPrize, count);
    }
}
