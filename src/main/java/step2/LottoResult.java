package step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> numberOfMatches;

    private LottoResult(Map<Integer, Integer> numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static LottoResult makeResult() {
        Map<Integer, Integer> numberOfMatches = new HashMap<>();
        numberOfMatches.put(3, 0);
        numberOfMatches.put(4, 0);
        numberOfMatches.put(5, 0);
        numberOfMatches.put(6, 0);

        return new LottoResult(numberOfMatches);
    }

    public Map<Integer, Integer> countNumber(List<List<Integer>> numbers, List<Integer> winningNumbers) {
        for (List<Integer> number : numbers) {
            int count = count(number, winningNumbers);
            Integer value = numberOfMatches.get(count);
            numberOfMatches.put(count, ++value);
        }

        return numberOfMatches;
    }

    private int count(List<Integer> number, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            count = matchNumber(number, count, winningNumber);
        }

        return count;
    }

    private int matchNumber(List<Integer> number, int count, Integer winningNumber) {
        if (number.contains(winningNumber)) {
            count++;
        }
        return count;
    }
}
