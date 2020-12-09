package com.bili.tool.algori.graph;

import java.util.*;

/**
 * 递归回溯+BFS
 */
public class LockBFS {

    public int openLock(String[] deadends, String target) {
        int step = 0;
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            dead.add(deadends[i]);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //如果遇到走不通的节点，说明该节点下的所有子节点都不行
                if (dead.contains(cur)) {
                    continue;
                }
                //一旦遇到目标节点，立即返回从根节点到该节点的最短距离
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    //将该节点下一层的所有邻近节点加入队列
                    String up = upTurn(cur,j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = downTurn(cur,j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 将数字向上翻转
     */
    public static String upTurn(String s, int index) {
        if (index < 0 || index > s.length()) {
            return null;
        }
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    /**
     * 将数字向下翻转
     */
    public static String downTurn(String s, int index) {
        if (index < 0 || index > s.length()) {
            return null;
        }
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }
}


