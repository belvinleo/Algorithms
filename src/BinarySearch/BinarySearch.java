package BinarySearch;

public class BinarySearch {
    public static int BinarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int BinarySearchRecursion(int[] arr, int low, int high, int target){
        if(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                return BinarySearchRecursion(arr, mid+1, high, target);
            } else {
                return BinarySearchRecursion(arr, low, mid-1, target);
            }
        }
        return -1;
    }

    public static int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= target){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int InsertPosition(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void FloornCeil(int[] arr, int target){

    }





    public static void main(String[] args) {
        int[] arr = {3,4,4,7,8,10};
        FloornCeil(arr, 8);

    }
}
