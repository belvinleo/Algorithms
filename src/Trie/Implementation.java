package Trie;

import java.util.HashMap;
import java.util.Map;

public class Implementation {
    class Node{
        Map<Character, Node> children = new HashMap<>();
        boolean isEnd = false;
        int pass = 0;
        int end = 0;
    }

    private final Node root = new Node();

    public void insert(String word){
        if (word == null) return;
        Node curr = root;
        curr.pass++;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            curr = curr.children.computeIfAbsent(c, character -> new Node());
            curr.pass++;
        }
        curr.isEnd = true;
        curr.end++;
    }


}
