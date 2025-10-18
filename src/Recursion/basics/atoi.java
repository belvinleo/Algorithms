package Recursion.basics;

public class atoi {
    public static int atoi(String s){
        return atoiHelper(s, 0);
    }

    public static int atoiHelper(String s, int index){
        if (index == s.length()){
            return 0;
        }

        int digit = s.charAt(index) - '0';

        int partial = atoiHelper(s, index + 1);

        return digit * (int) Math.pow(10, s.length() - index - 1) + partial;
    }

    public static void main(String[] args) {
        String s = "12345";
        int ans = atoi(s);
        System.out.print(ans);
    }
}
