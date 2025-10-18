package Strings;

import java.util.HashMap;

public class Strings {
    public static String removeOuterParanthesis(String s){
        //input = "( () () )  ( () )"
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            } else if (ch == ')') {
                depth--;
                if (depth > 0){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    public static String reverseWords(String s){
        //input = "the sky is blue"

        //remove trailing and leading whitespacing
        String[] words = s.trim().split("\\s+");

        //reversing the string into string builder
        StringBuilder reversed = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();

    }

    public static String largestOddNumeber(String num){
        //input = "32457"
        for(int i = num.length() - 1; i >= 0; i--){
            char ch = num.charAt(i);
            if ((ch - '0') % 2 != 0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public static String longestCommonPrefix(String[] strs){
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < strs[0].length() - 1) {
            char ch1 = strs[0].charAt(i);
            char chf = 0;
            while (j < strs[i].length() - 1) {
                char ch2 = strs[i].charAt(j);
                if (ch1 == ch2) {
                    chf = ch1;
                    break;
                }
                j++;
            }
            i++;
            ans.append(chf);
        }
        return ans.toString();
    }

    public static boolean isomorphicString(String s, String t) {
        for (int i = 0; i < s.length() - 1; i++){
            if ( (s.charAt(i) - t.charAt(i)) != (s.charAt(i+1) - t.charAt(i+1)) ){
                return false;
            }
        }
        return true;
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) return true;
        }
        return false;
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] hashS = new int[26];
        int[] hashT = new int[26];

        //precompute
        for(int i = 0; i < s.length(); i++){
            hashS[(s.charAt(i)) - 'a']++;
            hashT[(t.charAt(i)) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(hashS[i] != hashT[i]){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
    }
}
