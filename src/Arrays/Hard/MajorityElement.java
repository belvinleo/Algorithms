package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for (int num : nums){
            if(num == candidate1){
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums){
            if (num == candidate1){
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length/3){
            result.add(candidate1);
        }
        if (count2 > nums.length/3) {
            result.add(candidate2);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 2, 3};
        List<Integer> result = majorityElement(nums);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
