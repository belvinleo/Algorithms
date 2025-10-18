package Arrays.Hard;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int[] temp = new int[nums.length];
        return sortAndCount(nums, temp, 0, nums.length - 1);
    }

    private int sortAndCount(int[] a, int[] temp, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int count = sortAndCount(a, temp, l, m) + sortAndCount(a, temp, m + 1, r);

        // count cross reverse pairs
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if ((long) a[i] > 2L * a[j]) {
                count += (m - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // merge
        System.arraycopy(a, l, temp, l, r - l + 1);
        i = l; j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            if (temp[i] <= temp[j]) a[k++] = temp[i++];
            else a[k++] = temp[j++];
        }
        while (i <= m) a[k++] = temp[i++];
        while (j <= r) a[k++] = temp[j++];
        return count;
    }
    public static void main(String[] args) {

    }
}
