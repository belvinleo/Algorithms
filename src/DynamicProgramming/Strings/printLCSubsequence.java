package DynamicProgramming.Strings;

public class printLCSubsequence {
    public static String printLCS(String t1, String t2){
        int m = t1.length();
        int n = t2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m; int j = n;

        while(i > 0 && j > 0){
            if(t1.charAt(i-1) == t2.charAt(j-1)){
                lcs.append(t1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }
    public static void main(String[] args) {
        String ans = printLCS("abcde", "ace");
        System.out.print(ans);
    }
}
