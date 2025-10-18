package Arrays.Easy;

public class CheckSort {
    public static boolean CheckSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        boolean ans = CheckSort(nums);
        System.out.print(ans);
    }
}
