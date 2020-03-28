package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortEncodingofWords {
    public static int runSolution1(String[] words) {
        Solution1 solution = new Solution1();
        return solution.minimumLengthEncoding(words);
    }

    public static int runSolution2(String[] words) {
        Solution2 solution = new Solution2();
        return solution.minimumLengthEncoding(words);
    }
}

/**
 * 方法一 反转+排序：
 * 时间复杂度 O(nlog(n))
 */
class Solution1 {
    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    int minimumLengthEncoding(String[] words) {
        int i, ans = 0;
        for (i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        Arrays.sort(words);
        for (i = 0; i < words.length - 1; i++) {
            if (words[i].length() <= words[i + 1].length() && words[i].equals(words[i + 1].substring(0, words[i].length())))
                continue;
            ans += words[i].length() + 1;
        }
        return ans + words[i].length() + 1;
    }
}

/**
 * 方法二 字典树
 * 时间复杂度 O(∑wi) 其中 wi 是 words[i] 的长度。对于每个单词中的每个字母，只需要进行常数次操作。
 */
class Solution2 {
    int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            // 倒着插入
            for (int j = words[i].length() - 1; j >= 0; j--) {
                cur = cur.getNext(words[i].charAt(j));
            }
            mp.put(cur, i);  // 插入字符串的末尾节点与该字符串在输入字符串数组中对应的位置
        }
        int ans = 0;
        for (TrieNode t : mp.keySet()) {
            if (t.count == 0)  // 如果一个字符串是另一个字符串的前缀，则其末尾节点记录的count必定不为0，因为肯定存在子节点
                ans += words[mp.get(t)].length() + 1;
        }
        return ans;
    }

}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    int count;  // 记录该节点的子节点数

    public TrieNode() {
        this.count = 0;
    }

    public TrieNode getNext(char ch) {
        if (child[ch - 'a'] == null) {
            TrieNode node = new TrieNode();
            child[ch - 'a'] = node;
            count++;
        }
        return child[ch - 'a'];
    }
}