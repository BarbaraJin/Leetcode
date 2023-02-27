package DepthBreadthFirstSearch.medium;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import print.Print;

public class countSubTrees1519 {
    //TODO: TO BE REVIEWED
    //======================================== first try ========================================
    public static int[] countSubTrees1(int n, int[][] edges, String labels) {
        int[] answer = new int[n];
        if (n == 1) {
            answer[0] = 1;
            return answer;
        }
        Set<Integer> parents = new HashSet<>();
        countSubTreesHelp1(0, edges, labels.toCharArray(), answer, parents);
        return answer;
    }

    private static Map<Character, Integer> countSubTreesHelp1(int node, int[][] edges, char[] labels, int[] answer,
            Set<Integer> parents) {
        parents.add(node);
        Set<Integer> subNodes = findSubTreeOfNodeX(node, edges, parents);
        char c = labels[node];
        Map<Character, Integer> nodeCount = new HashMap<>();
        subNodes.forEach(subNode -> {
            mergeToMap1(nodeCount, countSubTreesHelp1(subNode, edges, labels, answer,
                    parents));
        });
        nodeCount.computeIfAbsent(c, i -> {
            return 0;
        });
        Integer cCount = nodeCount.get(c) + 1;
        nodeCount.put(c, cCount);
        answer[node] = cCount;
        return nodeCount;
    }

    public static Set<Integer> findSubTreeOfNodeX(int x, int[][] edges,
            Set<Integer> parents) {
        Set<Integer> a = new HashSet<>();
        for (int[] edge : edges) {
            if (edge[0] == x && !parents.contains(edge[1])) {
                a.add(edge[1]);
            } else if (edge[1] == x && !parents.contains(edge[0])) {
                a.add(edge[0]);
            }
        }
        return a;
    }

    //======================================== second try ========================================

    public static int[] countSubTrees2(int n, int[][] edges, String labels) {
        int[] answer = new int[n];
        if (n == 1) {
            answer[0] = 1;
            return answer;
        }
        Map<Integer, Set<Integer>> parentMap = parseEdges(edges);
        countSubTreesHelp2(0, edges, labels.toCharArray(), answer, parentMap);
        return answer;
    }

    private static Map<Integer, Set<Integer>> parseEdges(int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        Map<Integer, Set<Integer>> parentMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], e -> new HashSet<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], e -> new HashSet<>());
            edgeMap.get(edge[1]).add(edge[0]);
        }
        Set<Integer> allParent = new HashSet<>();
        Set<Integer> parent = new HashSet<>();
        parent.add(0);
        while (!parent.isEmpty()) {
            allParent.addAll(parent);
            Set<Integer> p2 = new HashSet<>();
            parent.forEach(p -> {
                Set<Integer> c = edgeMap.get(p);
                c.removeAll(allParent);
                parentMap.put(p, c);
                p2.addAll(c);
            });
            parent = p2;
        }
        return parentMap;
    }

    private static Map<Character, Integer> countSubTreesHelp2(int node, int[][] edges, char[] labels, int[] answer,
            Map<Integer, Set<Integer>> parentMap) {
        Set<Integer> subNodes = parentMap.get(node);
        char c = labels[node];
        Map<Character, Integer> nodeCount = new HashMap<>();
        subNodes.forEach(subNode -> {
            mergeToMap1(nodeCount, countSubTreesHelp2(subNode, edges, labels, answer,
                    parentMap));
        });
        nodeCount.computeIfAbsent(c, i -> {
            return 0;
        });
        Integer cCount = nodeCount.get(c) + 1;
        nodeCount.put(c, cCount);
        answer[node] = cCount;
        return nodeCount;
    }

    private static void mergeToMap1(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        map2.forEach((c, v) -> {
            map1.computeIfAbsent(c, i -> {
                return 0;
            });
            map1.put(c, map1.get(c) + v);
        });
    }

    // ======================================== copied answer ========================================

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        helper(graph, ans, 0, -1, labels);
        return ans;
    }

    public static int[] helper(List<Integer>[] graph, int[] ans, int cur, int parent, String labels) {
        int[] cnt = new int[26];
        for (int next : graph[cur]) {
            if (next == parent)
                continue;
            int[] arr = helper(graph, ans, next, cur, labels);
            for (int i = 0; i < 26; i++) {
                cnt[i] = cnt[i] + arr[i];
            }
        }
        char c = labels.charAt(cur);
        cnt[c - 'a']++;
        ans[cur] = cnt[c - 'a'];
        return cnt;
    }

    // ========================================fix==========================================================

    public static int[] countSubTrees3(int n, int[][] edges, String labels) {
        int[] answer = new int[n];
        if (n == 1) {
            answer[0] = 1;
            return answer;
        }
        Map<Integer, Set<Integer>> graph = parseEdges3(edges);
        Set<Integer> parent = new HashSet<>();
        countSubTreesHelp3(0, labels.toCharArray(), answer, graph, parent);
        return answer;
    }

    private static Map<Integer, Set<Integer>> parseEdges3(int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], e -> new HashSet<>());
            edgeMap.computeIfAbsent(edge[1], e -> new HashSet<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        return edgeMap;
    }

    private static Map<Character, Integer> countSubTreesHelp3(int node, char[] labels, int[] answer,
            Map<Integer, Set<Integer>> graph, Set<Integer> parent) {
        parent.add(node);
        Set<Integer> subNodes = graph.get(node);
        char c = labels[node];
        Map<Character, Integer> nodeCount = new HashMap<>();
        subNodes.forEach(subNode -> {
            if (!parent.contains(subNode)) {
                mergeToMap1(nodeCount, countSubTreesHelp3(subNode, labels, answer, graph, parent));
            }
        });
        nodeCount.computeIfAbsent(c, i -> {
            return 0;
        });
        Integer cCount = nodeCount.get(c) + 1;
        nodeCount.put(c, cCount);
        answer[node] = cCount;
        return nodeCount;
    }

    public static void main(String[] args) throws Exception {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        String labels = "abaedcd";

        int n1 = 4;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 0, 3 } };
        String labels1 = "bbbb";

        int n2 = 1;
        int[][] edges2 = {};
        String labels2 = "a";

        int n3 = 5;
        int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 0, 4 } };
        String labels3 = "aabab";

        int n4 = 4;
        int[][] edges4 = { { 0, 2 }, { 0, 3 }, { 1, 2 } };
        String labels4 = "aeed";

        Date start = new Date();
        int[] answer = countSubTrees(n, edges, labels);
        int[] answer1 = countSubTrees(n1, edges1, labels1);
        int[] answer2 = countSubTrees(n2, edges2, labels2);
        int[] answer3 = countSubTrees(n3, edges3, labels3);
        int[] answer4 = countSubTrees(n4, edges4, labels4);
        // int[] answer5 = countSubTrees(n5, edges5, labels5);
        Date end = new Date();
        Print.printArrayInteger(answer);
        Print.printArrayInteger(answer1);
        Print.printArrayInteger(answer2);
        Print.printArrayInteger(answer3);
        Print.printArrayInteger(answer4);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
