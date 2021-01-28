package util;

import java.util.HashMap;

/**
 * 数据结构：前缀树
 * 前缀树又称字典树，trie
 * 前缀树用来存储，查找字符串，特别适合字符串前缀查找，进行剪枝的时间优化。
 * 字符串公共前缀只保存一次，节省空间。
 */
public class Tire {
    private TireNode root;

    public Tire(TireNode root) {
        this.root = root;
    }

    public void insert(String word) {
        TireNode node = root;
        HashMap<Character, TireNode> children = node.children;

        for (char c : word.toCharArray()) {
            if (!children.containsKey(c)) {
                children.put(c, new TireNode());
            }
            node = children.get(c);
            children = node.children;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TireNode node = searchNode(word);

        return node != null && node.isWord;
    }

    public boolean startWith(String prefix) {
        return searchNode(prefix) != null;
    }


    private TireNode searchNode(String str) {
        TireNode node = root;

        for (char c : str.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }

        return node;
    }
}

class TireNode {
    char c;
    HashMap<Character, TireNode> children = new HashMap<>();
    boolean isWord = false;

    public TireNode(char c) {
        this.c = c;
    }

    public TireNode() {
    }
}