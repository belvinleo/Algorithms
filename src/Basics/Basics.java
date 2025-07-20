package Basics;

public class Basics {
    public static void countDigits(int num){
        int count = 0;
        while(num > 0){
            num = num / 10;
            count++;
        }
        System.out.print(count);
    }

    public static void reverseDigits(int num){
        int new_num = 0;
        int digit = 0;
        while(num > 0){
            digit = num % 10;
            new_num = (new_num * 10) + digit;
            num = num / 10;
        }
        System.out.print(new_num);
    }

    public static void checkPalindrome(int num){
        int n = num;
        int new_num = 0;
        int digit = 0;
        while (num > 0){
            digit = num % 10;
            new_num = (new_num * 10) + digit;
            num = num / 10;
        }
        if(new_num == n) {
            System.out.print("Palindrome");
        } else {
            System.out.print("Not a Palindrome");
        }
    }

    public static void ArmstrongNum(int num){
        int digit = 0;
        int num2 = 0;
        int n = num;
        while(num > 0){
            digit =  num % 10;
            num2 = num2 + (digit*digit*digit);
            num = num / 10;
        }
        if(num2 == n){
            System.out.print("Armstrong Number");
        } else {
            System.out.print("Not a Armstrong Number");
        }
    }

    public static void CheckPrime(int num){
        int count = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                count++;
            }
        }
        if(count == 2){
            System.out.print("Prime");
        } else {
            System.out.print("Not a prime");
        }
    }

    public static void findGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.print(a);
    }

    public static void main(String[] args) {
        CheckPrime(13);
    }
}
