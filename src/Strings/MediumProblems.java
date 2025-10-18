package Strings;

import java.util.*;

public class MediumProblems {

    public static String sortFrequency(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency in descending order
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static int maxDepth(String s) {
        int maxdepth = 0;
        int depth = 0;
        for(int i = 0; i < s.length() - 1 ; i++){
            if(s.charAt(i) == '(') {
                depth++;

            } else if (s.charAt(i) == ')') {
                depth--;
            }
            if(depth > maxdepth) {
                maxdepth = depth;
            }
        }
        return maxdepth;
    }

    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int curr = map.get(s.charAt(i));
            if(curr < prev){
                result -= curr;
            } else  {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    public static int sumOfBeauty(String s){
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                int idx = s.charAt(j - 'a');
                freq[idx]++;

                int maxF = 0;
                int minF = Integer.MAX_VALUE;
                for(int f : freq){
                    if (f == 0) continue;
                    if (f > maxF) maxF = f;
                    if (f < minF) minF = f;
                }
                ans += (maxF - minF);
            }
        }
        return ans;
    }
}
