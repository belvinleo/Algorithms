package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // 1. Traverse Right (Fixed Row: top, Column: left to right)
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Shrink top boundary

            // Check boundary condition again after shrinking
            if (top > bottom) break;

            // 2. Traverse Down (Fixed Column: right, Row: top to bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Shrink right boundary

            // Check boundary condition again after shrinking
            if (left > right) break;

            // 3. Traverse Left (Fixed Row: bottom, Column: right to left)
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--; // Shrink bottom boundary

            // Check boundary condition again after shrinking
            if (top > bottom) break;

            // 4. Traverse Up (Fixed Column: left, Row: bottom to top)
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++; // Shrink left boundary
        }

        return result;
    }
}
