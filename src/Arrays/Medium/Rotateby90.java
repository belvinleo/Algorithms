package Arrays.Medium;

public class Rotateby90 {
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
}
