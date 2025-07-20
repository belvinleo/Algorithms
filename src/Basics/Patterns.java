package Basics;

public class Patterns {
    public static void patt1(int n){
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt2(int n){
        for(int i=0; i <= n; i++) {
            for(int j=0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt3(int n){
        for(int i=1; i <= n; i++){
            for(int j=1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patt4(int n){
        for(int i=1; i <= n; i++){
            for(int j=1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void patt5(int n){
        for(int i=5; i > 0; i--){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt6(int n){
        for(int i=n; i > 0; i--){
            for(int j=1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patt7(int n){
        for(int i=0; i<n; i++){
            for(int j=n; j>i; j--){
                System.out.print(" ");
            }
            for(int k=0; k<=i; k++){
                System.out.print("*");
            }
            for(int l=0; l<i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt8(int n){
        for(int i=0; i < n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k=n; k > i ; k--){
                System.out.print("*");
            }
            for(int l=n-1; l > i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt9(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            for (int l = 0; l < i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k = n; k > i; k--){
                System.out.print("*");
            }
            for(int l = n-1; l > i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt10(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<n; i++){
            for(int j=n; j > i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt11(int n){
        int start = 0;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) start = 1;
            else start = 0;
            for(int j = 0; j <= i; j++){
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void patt12(int n){
        for(int i=1; i<n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            for(int k=n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int k=n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int l=i; l > 0; l--){
                System.out.print(l);
            }
            System.out.println();
        }
    }

    public static void patt13(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void patt14(int n){
        String[] arr = {"A", "B", "C", "D", "E"};
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }

    public static void patt15(int n){
        String[] arr = {"E", "D", "C", "B", "A"};
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= i; j--){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }

    public static void patt16(int n){
        String[] arr = {"A", "B", "C", "D", "E"};
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static void patt17(int n){
        String[] arr = {"A", "B", "C", "D", "E"};
        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for(int k = 0; k <= i; k++){
                System.out.print(arr[k]);
            }
            for(int l = i; l > 0; l--){
                System.out.print(arr[l-1]);
            }
            System.out.println();
        }
    }

    public static void patt19(int n){
        for(int i = 0; i < n; i++){
            for(int j = n; j > i; j--){
                System.out.print("*");
            }
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int l = n; l > i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            for(int k = n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int k = n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int l = 0; l <= i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt20(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            for(int k = n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int k = n-1; k > i; k--){
                System.out.print(" ");
            }
            for(int l = 0; l <= i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = n; j > i; j--){
                System.out.print("*");
            }
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int l = n; l > i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt21(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j==0 || j==n-1 || i==0 || i==n-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        patt19(5);
    }
}
