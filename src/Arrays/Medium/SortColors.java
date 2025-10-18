package Arrays.Medium;

public class SortColors {
    public static void sortcolors(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] < nums[j]){
                    int k = nums[i];
                    nums[i] = nums[j];
                    nums[j] = k;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortcolors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
