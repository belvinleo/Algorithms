package Arrays.Easy;

public class SingleNumber {
    public static int SingleNumber(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                return arr[i];
            }
        }
        return 0;
    }
}
