package Recursion.Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static List<List<Integer>> subsetWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack4(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack4(List<List<Integer>> result, List<Integer> current, int[] nums, int index){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack4(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
