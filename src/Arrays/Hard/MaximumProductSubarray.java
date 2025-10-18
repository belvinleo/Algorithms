package Arrays.Hard;

public class MaximumProductSubarray {
    public static int MaximumProductSubarray(int[] arr){
        int n = arr.length;
        int maxproduct = arr[0];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int product = 0;
                for(int k = i; k <= j; k++){
                    if(product == 0){
                        product = product + arr[k];
                    } else {
                        product = product * arr[k];
                    }
                }
                if(product > maxproduct){
                    maxproduct = product;
                }
            }
        }
        return maxproduct;
    }
}
