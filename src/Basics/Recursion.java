package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void printNtimes(int i, int n){
        if(i > n) return;
        else {
            System.out.println("Belvin");
            printNtimes(i+1,n);
        }
    }

    public static void printNumNtimes(int i, int n){
        if(i > n) return;
        else{
            System.out.println(i);
            printNumNtimes(i+1, n);
        }
    }

    public static void printNto1(int i, int n){
        if(i > n) return;
        else{
            System.out.println(n);
            printNto1(1, n-1);
        }
    }

    public static int sumOfNnum(int n){
        int sum = 0;
        if(n == 0) return sum;
        else{
            return n + sumOfNnum(n-1);
        }
    }

    public static int factorial(int n){
        if(n == 0) return 1;
        else{
            return n * factorial(n-1);
        }
    }

    public static void reverseArray(int[] arr, int start, int end){
        if(start > end) return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }

    public static boolean isPalindrome(String s){
        StringBuilder filtered = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filtered.append(Character.toLowerCase(c));
            }
        }
        return recursive(filtered.toString(), 0, filtered.length() - 1);
    }

    private static boolean recursive(String s, int left, int right){
        if(left >= right) return true;
        if(s.charAt(left) != s.charAt(right)) return false;
        else return recursive(s, left+1, right-1);
    }

    public static void main(String[] args) {;
//        boolean ans = isPalindrome("A man, a plan, a canal: Panama");
//        System.out.print(ans);
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }

    }
}