package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6L, false),
    SECOND(5L, true),
    THIRD(5L, false),
    FOURTH(4L, false),
    FIFTH(3L, false);

    private final long matchCount;
    private final boolean hasBonus;

    LottoRank(long matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public static LottoRank from(LottoScore lottoScore) {
        return Arrays.stream(values())
                .filter(lottoRank -> isMatched(lottoScore, lottoRank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 점수가 없습니다."));
    }

    public static boolean isRanked(LottoScore lottoScore) {
        return FIFTH.matchCount <= lottoScore.getMatchCount();
    }

    private static boolean isMatched(LottoScore lottoScore, LottoRank lottoRank) {
        if (shouldCheckBonus(lottoScore)) {
            return lottoRank.hasSameMatchCount(lottoScore) && lottoRank.hasSameBonusCondition(lottoScore);
        }
        return lottoRank.hasSameMatchCount(lottoScore);
    }

    private static boolean shouldCheckBonus(LottoScore lottoScore) {
        return SECOND.hasSameMatchCount(lottoScore) || THIRD.hasSameMatchCount(lottoScore);
    }

    private boolean hasSameMatchCount(LottoScore lottoScore) {
        return lottoScore.getMatchCount() == this.matchCount;
    }

    private boolean hasSameBonusCondition(LottoScore lottoScore) {
        return lottoScore.hasBonusNumber() == this.hasBonus;
    }
}
