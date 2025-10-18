package BitManipulation;

public class BitManipulation {
    public static String convert2Binary(int n){
        String result = "";
        while(n != 1) {
            result = (n % 2) + result;
            n = n / 2;
        }
        return result;
    }

    public static int convert2Decimal(String s){
        int decimal = 0;
        for(int i = 0; i < s.length(); i++){
            int bit = s.charAt(s.length() - 1 - i) - '0';
            decimal += bit * Math.pow(2,i);
        }
        return decimal;
    }

    //checking ith bit is set or not
    public static boolean isBitSet(int n, int i){
        int mask = (1 << i);
        return (n & mask) != 0;
    }

    //check odd number
    public static boolean isOdd(int n){
        return (n % 2) != 0;
    }

    //check n is power of 2
    public static boolean isPower(int n){
        if (n <= 0) return false;

        while (n % 2 == 0){
            n = n / 2;
        }
        return n == 1;
    }

    //count number of set bits
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    //set rightmost bit to 1
    public int setRightmostUnsetBit(int n) {
        return n | (n + 1);
    }

    //swap two numbers
    public void swap(int[] arr){
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
    }

    public static void main(String[] args) {
        boolean ans = isBitSet(5, 1);
        System.out.print(ans);
    }
}
