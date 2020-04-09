package com.leetcode.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Generate_ParenthesesTest {
    @Test
    public void test() {
        List<String> res = Generate_Parentheses.generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
        System.out.println();
        res = Generate_Parentheses.generateParenthesis2(3);
        for (String str : res) {
            System.out.println(str);
        }
    }
}