package Trie;

import java.util.HashMap;
import java.util.Map;

public class Implementation {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }


    }

}
