package com.bili.tool.test;


import java.util.*;

public class Main {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || !wordList.contains(endWord)) {
            return 0;
        }
        //bfs:求beginWord到endWord的最短距离。
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                List<String> neighbors = findNeighbors(str, wordList);
                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) {
                        return step+1;
                    }
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static List<String> findNeighbors(String target, List<String> wordList) {
        List<String> l = new ArrayList<>();
        for (String s : wordList) {
            if (isOneLetterDiff(target, s)) {
                l.add(s);
            }
        }
        return l;
    }

    public static boolean isOneLetterDiff(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        if (ch1.length != ch2.length) {
            return false;
        }
        int diffLetters = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                diffLetters++;
            }
        }
        return diffLetters == 1 ? true : false;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
