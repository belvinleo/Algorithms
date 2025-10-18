package Arrays.Easy;

public class SecondLargestElement {
    public static int SecondLargestElement(int[] arr){
        int max = 0;
        int max2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max2 && arr[i] < max){
                max2 = arr[i];
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        int ans = SecondLargestElement(nums);
        System.out.print(ans);
    }
}
