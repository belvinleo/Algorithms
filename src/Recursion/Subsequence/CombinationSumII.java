package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Important to sort for duplicate skipping
        backtrack3(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack3(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;  // Prune the search (sorted input)

            current.add(candidates[i]);
            backtrack3(result, current, candidates, target - candidates[i], i + 1); // i+1 since we can't reuse elements
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
