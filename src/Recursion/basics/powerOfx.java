package Recursion.basics;

public class powerOfx {
    public static double power(double x, int n){
        if (n == 0) return 1;
        if (n < 0) return 1 / power(x, -n);

        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return x * half * half;
    }
    public static void main(String[] args) {

    }
}
