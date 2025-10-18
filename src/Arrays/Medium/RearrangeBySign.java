package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {
    public static int[] rearrangeArray(int[] nums){
        int[] result = new int[nums.length];
        int p = 0;
        int n = 1;
        for(int num : nums){
            if(num > 0){
                result[p] = num;
                p += 2;
            } else {
                result[n] = num;
                n += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = rearrangeArray(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
