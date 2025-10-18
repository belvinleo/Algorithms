package Arrays.Easy;

import java.util.ArrayList;

public class Union {
    public static void Union(int[] arr1, int[] arr2){
        ArrayList<Integer> temp = new ArrayList<>();
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                temp.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                temp.add(arr2[j]);
                j++;
            } else if (arr1[i] == arr2[j]){
                temp.add(arr1[i]);
                i++; j++;
            }
        }
        while(i < m){
            temp.add(arr1[i]);
            i++;
        }
        while (j < n){
            temp.add(arr2[j]);
            j++;
        }
        System.out.print(temp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        int[] nums1 = {1, 2, 2, 4, 5, 6};
        Union(nums, nums1);
        System.out.print(nums);
    }
}
