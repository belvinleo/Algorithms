package Arrays.Easy;

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void RemoveDuplicates(int[] arr){
        int n = arr.length;
        int k = 1;
        String str = "_";
        for(int i = 1; i < n; i++){
            if(arr[i] != arr[k-1]){
                arr[k] = arr[i];
                k++;
            }
        }
        ArrayList<String> temp = new ArrayList<>();
        for(int j = 0; j < n; j++){
            if(j < k){
                temp.add(String.valueOf(arr[j]));
            } else {
                temp.add("_");
            }
        }
        System.out.println(temp);
        System.out.print(k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        RemoveDuplicates(nums);
        System.out.print(nums);
    }
}
