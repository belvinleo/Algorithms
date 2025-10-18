package Arrays.Medium;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose the matrix (swap elements across the main diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Ensure j starts at i to only swap each pair once
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row (swap elements from start to end of the row)
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
