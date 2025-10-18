package Arrays.Medium;

public class TwoSum {
    public static int[] TwoSum(int[] arr, int target){
        int n = arr.length;
        int[] indices = new int[2];
        for(int i = 0; i < n-1; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
}
