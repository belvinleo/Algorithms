package Arrays.Medium;

public class StockBuynSell {
    public static int StockBuynSell(int[] arr){
        int n = arr.length;
        int maxprofit = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int diff = 0;
                diff = arr[j] - arr[i];
                if(diff > maxprofit){
                    maxprofit = diff;
                }
            }
        }
        return maxprofit;
    }
}
