package Arrays.Hard;

public class CountInversions {
    public static long countInversions(int[] nums){
        int n = nums.length;
        int[] temp = new int[n];
        return sortAndCount(nums, temp, 0, n - 1);
    }

    private static long sortAndCount(int[] a, int[] temp, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        long inv = 0;
        inv += sortAndCount(a, temp, l, m);
        inv += sortAndCount(a, temp, m + 1, r);
        inv += mergeAndCount(a, temp, l, m, r);
        return inv;
    }

    private static long mergeAndCount(int[] a, int[] temp, int l, int m, int r) {
        System.arraycopy(a, l, temp, l, r - l + 1);
        int i = l, j = m + 1, k = l;
        long inv = 0;

        while (i <= m && j <= r) {
            if (temp[i] <= temp[j]) {
                a[k++] = temp[i++];
            } else {
                a[k++] = temp[j++];
                inv += (m - i + 1); // all remaining in left are > temp[j]
            }
        }
        while (i <= m) a[k++] = temp[i++];
        while (j <= r) a[k++] = temp[j++];
        return inv;
    }

    public static void main(String[] args) {

    }
}
