package com.bili.tool.algori.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseBFS {
    public static int[][] graph = {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0}
    };
    static String[] nodes = {"A", "B", "C", "D", "E", "F", "G", "H"};
    static int[] visited = new int[graph.length];

    public static void bFSTraversal(int[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[val][i] == 1 && visited[i] != 1) {
                    visit(i);
                    queue.offer(i);
                }
            }
        }
    }

    public static void visit(int value) {
        System.out.println(nodes[value]);
        visited[value] = 1;
    }

    public static void main(String[] args) {
        bFSTraversal(graph, 0);
    }

}
