package GreedyAlgorithms;

import java.util.Arrays;

public class AssignCookies {
    public static int assignCookies(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);

        int count = 0;
        int i = 0; int j = 0;

        while (i < greed.length && j < size.length) {
            if (size[j] >= greed[i]) {
                count++;
                i++;
                j++;
            } else {
                j++; // Try next bigger cookie
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] greed = {1, 2};
        int[] size = {1, 2, 3};

        int ans = assignCookies(greed, size);
        System.out.print(ans);
    }
}
