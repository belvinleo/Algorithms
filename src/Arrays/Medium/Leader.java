package Arrays.Medium;

import java.util.ArrayList;

public class Leader {
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
}
