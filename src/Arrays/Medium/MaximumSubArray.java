package Arrays.Medium;

public class MaximumSubArray {
    public static void MaximumSubArray(int[] arr){
        int n = arr.length;
        int maxsum = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum = sum + arr[k];
                }
                if(sum > maxsum){
                    maxsum = sum;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(maxsum);
        for(int i = x; i <= y; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
