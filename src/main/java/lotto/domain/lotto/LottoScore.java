package lotto.domain.lotto;

public class LottoScore {

    private final long matchCount;
    private final boolean hasBonusNumber;

    public LottoScore(long matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
