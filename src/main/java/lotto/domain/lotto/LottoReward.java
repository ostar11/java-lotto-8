package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoReward {

    FIRST("6개 일치", 2_000_000_000L, LottoRank.FIRST),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000L, LottoRank.SECOND),
    THIRD("5개 일치", 1_500_000L, LottoRank.THIRD),
    FOURTH("4개 일치", 50_000L, LottoRank.FOURTH),
    FIFTH("3개 일치", 5_000L, LottoRank.FIFTH);

    private final String description;
    private final long prize;
    private final LottoRank lottoRank;

    LottoReward(String description, long prize, LottoRank lottoRank) {
        this.description = description;
        this.prize = prize;
        this.lottoRank = lottoRank;
    }

    public static LottoReward from(LottoScore lottoScore) {
        return Arrays.stream(values())
                .filter(lottoReward -> lottoReward.lottoRank == LottoRank.from(lottoScore))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 보상이 없습니다."));
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
