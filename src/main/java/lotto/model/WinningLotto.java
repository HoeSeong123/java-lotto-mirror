package lotto.model;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank compareLotto(Lotto lotto) {
        int correctCount = (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();

        boolean containBonusNumber = lotto.contains(bonusNumber);

        return Rank.valueOf(correctCount, containBonusNumber);
    }
}