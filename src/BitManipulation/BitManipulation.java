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
    public static void main(String[] args) {
        System.out.print(convert2Decimal("101"));
    }
}
