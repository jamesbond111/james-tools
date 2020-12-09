package com.bili.tool.algori.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPNDemo {
    public static void main(String[] args) {
        String[] token = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(token));
    }

    public static int evalRPN(String[] tokens) {
        Set<String> signals = new HashSet<>();
        signals.add("+");
        signals.add("-");
        signals.add("*");
        signals.add("/");
        if (tokens == null) {
            return 0;
        }
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (signals.contains(tokens[i])) {
                String a2 = stack.pop();
                String a1 = stack.pop();
                if ("+".equals(tokens[i])) {
                    res = Integer.valueOf(a1) + Integer.valueOf(a2);
                } else if ("-".equals(tokens[i])) {
                    res = Integer.valueOf(a1) - Integer.valueOf(a2);
                } else if ("*".equals(tokens[i])) {
                    res = Integer.valueOf(a1) * Integer.valueOf(a2);
                } else if ("/".equals(tokens[i])) {
                    res = Integer.valueOf(a1) / Integer.valueOf(a2);
                }
                stack.push(String.valueOf(res));
            } else {
                //如果是数字，则入栈
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
