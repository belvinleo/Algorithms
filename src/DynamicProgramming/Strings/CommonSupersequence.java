package DynamicProgramming.Strings;

public class CommonSupersequence {
    public static String shortestCommonSupersequence(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder scs = new StringBuilder();
        int i = m; int j = n;
        while(i > 0 && j > 0) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                scs.append(word1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(word1.charAt(i - 1));
                i--;
            } else {
                scs.append(word2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0){
            scs.append(word1.charAt(i-1));
            i--;
        }
        while (j > 0){
            scs.append(word2.charAt(j-1));
            j--;
        }
        return scs.toString();
    }
    public static void main(String[] args) {
        String ans = shortestCommonSupersequence("abac", "cab");
        System.out.print(ans);
    }
}
