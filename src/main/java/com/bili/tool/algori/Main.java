package com.bili.tool.algori;

import java.util.*;

class Main {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        letterCombinations0(res, sb, digits, 0, map);
        return res;
    }

    public void letterCombinations0(List<String> res, StringBuilder sb, String digits, int level, Map<Character, String> map) {
        if (level == digits.length()) {
            res.add(new String(sb.toString()));
            return;
        }
        char ch = digits.charAt(level);
        char[] chs = map.get(ch).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
            letterCombinations0(res, sb, digits, level + 1, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }




}

