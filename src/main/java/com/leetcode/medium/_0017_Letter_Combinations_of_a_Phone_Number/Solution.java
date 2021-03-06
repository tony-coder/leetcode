package com.leetcode.medium._0017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 深度优先遍历+哈希表（map存储）
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.equals("")) {
            return combinations;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "nmo");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        traceback(combinations, map, digits, 0, new StringBuffer());
        return combinations;
    }

    private void traceback(List<String> combinations, Map<Character, String> map, String digits, int index, StringBuffer tmp) {
        if (index == digits.length()) {
            combinations.add(tmp.toString());
        } else {
            char digit = digits.charAt(index);
            String s = map.get(digit);
            for (int i = 0; i < s.length(); i++) {
                tmp.append(s.charAt(i));
                traceback(combinations, map, digits, index + 1, tmp);
                tmp.deleteCharAt(index);
            }
        }

    }
}
