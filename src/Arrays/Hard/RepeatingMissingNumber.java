package Arrays.Hard;

public class RepeatingMissingNumber {
    public static int[] findErrorNums(int[] nums){
        int n = nums.length;
        int xs = 0;
        for (int i = 0; i < n; i++) {
            xs ^= nums[i];
            xs ^= (i + 1);
        }

        int lb = xs & -xs; // rightmost set bit
        int p = 0, q = 0;

        // Partition by lb for nums
        for (int v : nums) {
            if ((v & lb) != 0) p ^= v;
            else q ^= v;
        }
        // Partition by lb for 1..n
        for (int i = 1; i <= n; i++) {
            if ((i & lb) != 0) p ^= i;
            else q ^= i;
        }

        // Determine which is duplicate by counting one occurrence
        for (int v : nums) {
            if (v == p) return new int[] {p, q}; // p is A (duplicate), q is B (missing)
        }
        return new int[] {q, p}; // q is A, p is B
    }
    public static void main(String[] args) {

    }
}
