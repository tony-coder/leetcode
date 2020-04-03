package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * <p>
 * 建立自动机
 * 来自编译原理 确定有限状态机（deterministic finite automaton, DFA）
 * 字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。
 * 因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：
 * 我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。
 */
public class String_to_Integer_atoi {
    public static int myAtoi(String str) {
        Automation automation = new Automation();
        for (char c : str.toCharArray()) {
            automation.get(c);
        }
        return automation.sign * ((int) automation.ans);
    }
}

class Automation {
    private final String START = "start";
    private final String SIGNED = "signed";
    private final String IN_NUM = "in_number";
    private final String END = "end";

    Map<String, String[]> table;
    String state = START;

    int sign = 1;  // 符号
    long ans = 0;

    public Automation() {
        table = new HashMap<>();
        table.put(START, new String[]{START, SIGNED, IN_NUM, END});  // 状态+转移
        table.put(SIGNED, new String[]{END, END, IN_NUM, END});
        table.put(IN_NUM, new String[]{END, END, IN_NUM, END});
        table.put(END, new String[]{END, END, END, END});
    }

    public int get_col(char c) {
        if (Character.isSpaceChar(c))
            return 0;
        if (c == '+' || c == '-')
            return 1;
        if (Character.isDigit(c))
            return 2;
        return 3;
    }

    // 根据条件转移到下一个状态
    public void get(char c) {
        state = table.get(state)[get_col(c)];  // 获取转移后的状态
        if (state.equals(IN_NUM)) {
            /*
            // 32位环境下
            if (sign == 1 && ans > (Integer.MAX_VALUE - c + '0') / 10) {
                ans = Integer.MAX_VALUE;
                return;
            } else if (sign == -1 && (-1) * ans < (Integer.MIN_VALUE + c - '0') / 10) {
                ans = Integer.MIN_VALUE;
                return;
            }*/
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if (state.equals(SIGNED))
            sign = c == '+' ? 1 : -1;
    }
}
/*
//模拟
class Solution {
    public int myAtoi(String str) {
        char[] s=str.toCharArray();
        int pos=0,ans=0,symbol=1;
        if(s.length==0)
            return 0;
        while(pos<s.length && s[pos]==' ')
            pos++;
        if(pos>=s.length)
            return 0;
        if(s[pos]=='-'){
            symbol=-1;
            pos++;
        }else if(s[pos]=='+'){
            symbol=1;
            pos++;
        }else if(!Character.isDigit(s[pos]))
            return ans;
        while(pos<s.length && Character.isDigit(s[pos])){
            if(ans>(Integer.MAX_VALUE-s[pos]+'0')/10)
                return symbol==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            ans=ans*10+s[pos]-'0';
            pos++;

        }
        return ans*symbol;
    }
}*/
