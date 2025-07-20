package Arrays;

import java.util.ArrayList;

public class ArrayProblems {

    //Easy Problems
    public static int LargestElement(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

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

    public static boolean CheckSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

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

    public static void RotateArray(int[] arr, int k){
        int n = arr.length;
        for(int i = 0; i < k; i++){
            int temp = arr[0];
            for(int j = 0; j < n-1; j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = temp;
        }
    }

    public static void MoveZeros(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                for(int j = i; j < n-1; j++){
                    arr[j] = arr[j+1];
                }
                arr[n-1] = 0;
            }
        }
    }

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

    public static int MissingNumber(int[] arr){
        int n = arr.length;
        int sum1 = n*((n+1)/2);
        int sum2 = 0;
        for(int i = 0; i < n; i++){
            sum2 = sum2 + arr[i];
        }
        return sum1 - sum2;
    }

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

    //Medium Problems
    public static int[] TwoSum(int[] arr, int target){
        int n = arr.length;
        int[] indices = new int[2];
        for(int i = 0; i < n-1; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    public static void sortColorts(int[] arr){

    }

    public static int MajorityElement(int[] arr){
        int n = arr.length;
        int num = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != num){
                int count = 0;
                for(int j = 0; j < n; j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
                if(count > count2){
                    num = arr[i];
                    count2 = count;
                }
            }
        }
        return num;
    }

    public static void MaximumSubArray(int[] arr){
        int n = arr.length;
        int maxsum = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum = sum + arr[k];
                }
                if(sum > maxsum){
                    maxsum = sum;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(maxsum);
        for(int i = x; i <= y; i++){
            System.out.print(arr[i] + " ");
        }
    }

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

    public static int MaxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void Leader(int[] arr){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean leader = true;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader) list.add(arr[i]);
        }
        for(int k = 0; k < list.size(); k++){
            System.out.print(list.get(k) + " ");
        }
    }

    public static int LCS(int[] arr){
        return 0;
    }

    public static void SetMatrix(int[][] arr){

    }

    public static void Rotateby90(int[][] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            int[] temp = new int[n];

        }
    }

    //Hard Problems
    public static int MaximumProductSubarray(int[] arr){
        int n = arr.length;
        int maxproduct = arr[0];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int product = 0;
                for(int k = i; k <= j; k++){
                    if(product == 0){
                        product = product + arr[k];
                    } else {
                        product = product * arr[k];
                    }
                }
                if(product > maxproduct){
                    maxproduct = product;
                }
            }
        }
        return maxproduct;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};

        int[] arr2 = {3, -1, 4};
        int[][] arr3 = {{1,1,1},{1,0,1},{1,1,1}};
        int ans = MaximumProductSubarray(arr2);
        System.out.print(ans);

    }
}
