package Arrays.Easy;

public class LargestElement {
    public static int LargestElement(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        int ans = LargestElement(nums);
        System.out.print(ans);
    }
}
