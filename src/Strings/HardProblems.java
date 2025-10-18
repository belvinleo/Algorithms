package Strings;

public class HardProblems {

    //Minimum number of bracket reversals needed to make an expression balanced
    public static int minAddToMakeValid(String s){
        int open = 0;
        int insertions = 0;
        for (char c : s.toCharArray()){
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    insertions++;
                }
            }
        }
        return open + insertions;
    }

    //Rabin Karp algorithm
    public static int repeatedStringMatch(String a, String b){
        StringBuilder repeated = new StringBuilder();
        int count = 0;
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }
        if (repeated.indexOf(b) != -1) {
            return count;
        }
        repeated.append(a);
        count++;
        if (repeated.indexOf(b) != -1) {
            return count;
        }
        return -1;
    }

    //Z function
    public static int StrStr(String haystack, String needle){
        return haystack.indexOf(needle);
    }

    //shortest palindrome
    public static String shortestPalindrome(String s){
        int len = s.length();
        if (len <= 1) return s;

        int i = len - 1;
        for (; i >= 0; --i){
            if (isPaindrome(s, 0, i)){
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(0, i+1));
        sb.reverse().append(s);
        return sb.toString();
    }

    private static boolean isPaindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
