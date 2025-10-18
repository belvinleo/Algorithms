package Arrays.Easy;

public class ConsecutiveOnes {
    public static int ConsecutiveOnes(int[] arr){
        int n = arr.length;
        int count2 = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                count++;
            } else if (arr[i] == 0){
                count = 0;
            }
            if(count > count2) {
                count2 = count;
            }
        }
        return count2;
    }

}
