package BitManipulation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class interviewProblems {
    //Count number of bits to be flipped to convert A to B
    public static int minBitFlips(int start, int goal){
        int diff = start ^ goal;
        int flips = 0;
        while (diff != 0) {
            diff = diff & (diff - 1);
            flips++;
        }
        return flips;
    }

    //Find the number that appears odd number of times
    public static int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums){
            single = single ^ num;
        }
        return single;
    }

    //Find xor of numbers from L to R
    private int xorFromZero(int n) {
        int remainder = n % 4;

        if (remainder == 0) {
            return n;
        } else if (remainder == 1) {
            return 1;
        } else if (remainder == 2) {
            return n + 1;
        } else { // remainder == 3
            return 0;
        }
    }

    public int rangeXor(int L, int R) {
        // XOR[L, R] = XOR[0, R] ^ XOR[0, L-1]
        int xorR = xorFromZero(R);
        int xorL_minus_1 = xorFromZero(L - 1);

        return xorR ^ xorL_minus_1;
    }

    //Find the two numbers appearing odd number of times
    public static int[] singleNumberII(int[] nums){
        int xor_sum = 0;
        for (int num : nums) {
            xor_sum ^= num;
        }

        int discriminating_bit = xor_sum & (-xor_sum);

        int unique1 = 0;

        for (int num : nums) {
            if ((num & discriminating_bit) != 0) {
                unique1 ^= num;
            }
        }

        int unique2 = xor_sum ^ unique1;

        int[] result = {unique1, unique2};
        Arrays.sort(result);

        return result;
    }

    //count primes - Sieve of Eratosthenes
    public static int countPrimes(int n){
        if(n <= 2) return 0;
        boolean[] prime = new boolean[n];
        prime[0] = false;
        prime[1] = false;

        int limit = (int) Math.sqrt(n-1);
        for(int p = 2; p <= limit; p++){
            if (prime[p]){
                for (int m = p*p; m <= n; m+=p){
                    prime[m] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }

    //Prime factorisation
    public static List<List<Integer>> primeFactors(int[] queries){
        List<List<Integer>> result = new ArrayList<>();
        for (int num : queries){
            result.add(factors(num));
        }
        return result;
    }

    private static List<Integer> factors(int n){
        List<Integer> factors = new ArrayList<>();
        while (n % 2 == 0){
            factors.add(2);
            n /= 2;
        }

        for(int i = 3; i * i <= n; i += 2){
            while (n % i == 2){
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    //calculate of powen(n, x)


    public static void main(String[] args) {

    }
}
