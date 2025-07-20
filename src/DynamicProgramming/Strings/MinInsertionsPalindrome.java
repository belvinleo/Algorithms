package DynamicProgramming.Strings;

public class MinInsertionsPalindrome {
    public static int minInsertions(String s){
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][n];
        return n - lcs;
    }
    public static void main(String[] args) {
        int ans = minInsertions("mbadm");
        System.out.print(ans);
    }
}
