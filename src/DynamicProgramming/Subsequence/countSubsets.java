package DynamicProgramming.Subsequence;

public class countSubsets {
    public static int countSubset(int[] nums, int target){
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target+1];
        boolean ans = solve(nums, n-1, target, dp);
        int count = 0;
        for(int i = 0; i < n; i++){
            if(dp[i][target] == true){
                count++;
            }
        }
        return count;
    }

    public static boolean solve(int[] nums, int index, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(index < 0) return false;

        if(dp[index][target] != null) return dp[index][target];

        //Excluding element
        boolean notTake = solve(nums, index - 1, target, dp);

        //Including element
        boolean take = false;
        if(nums[index] <= target) {
            take = solve(nums, index - 1, target - nums[index], dp);
        }

        return dp[index][target] = take || notTake;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.print(countSubset(nums, 3));
    }
}
