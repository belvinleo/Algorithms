package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack5(result, new ArrayList<>(), k, target, 1);
        return result;
    }

    private static void backtrack5(List<List<Integer>> result, List<Integer> current, int k, int target, int index){
        if(current.size() == k && target == 0){
            result.add(new ArrayList<>(current));
        }
        if (current.size() > k || target < 0){
            return;
        }
        for(int i = index; i <= 9; i++) {
            current.add(i);
            backtrack5(result, current, k, target - i, i+1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
