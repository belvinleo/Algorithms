package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> triangle = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);

            for(int j = 1; j < i; j++){
                int val = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                newRow.add(val);
            }

            if(i > 0){
                newRow.add(1);
            }

            triangle.add(newRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.print(pascalTriangle(5));
    }
}
