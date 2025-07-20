package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <= n; i++){
            arr[i] = s.nextInt();
        }

        //precompute
        int[] hash = new int[13];
        for(int i = 0; i <= n; i++){
            hash[arr[i]]++;
        }

        int q = s.nextInt();
        while (q>0){
            int num = s.nextInt();
            //fetch
            System.out.println(hash[num]);
            q--;
        }
    }
    public static int maxFrequency(int[] nums, int k){
        int[] Hash = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            Hash[nums[i]] = nums[i];
        }
        return 10;
    }

}
