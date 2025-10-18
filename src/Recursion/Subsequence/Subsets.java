package Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack1(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack1(List<List<Integer>> result, List<Integer> current, int[] nums, int index){
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack1(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}
