package Arrays.Medium;

public class MajorityElement {
    public static int MajorityElement(int[] arr){
        int n = arr.length;
        int num = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != num){
                int count = 0;
                for(int j = 0; j < n; j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
                if(count > count2){
                    num = arr[i];
                    count2 = count;
                }
            }
        }
        return num;
    }
}
