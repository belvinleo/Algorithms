package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private static void backtrack2(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index){
        if (target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0){
            return;
        }

        for(int i = index; i < candidates.length; i++){
            current.add(candidates[i]);
            backtrack2(result, current, candidates, target - candidates[i], i+1);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
