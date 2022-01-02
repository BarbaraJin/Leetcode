package medium;

import java.util.*;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static int numPairsDivisibleBy60(int[] time) {
        int solution = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    solution++;
                }
            }
        }
        return solution;
    }

    public static int numPairsDivisibleBy60test1(int[] time) {
        int solution = 0;
        Map<Integer, List<Integer>> modMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            modMap.computeIfAbsent(time[i] % 60, j -> new ArrayList<>());
            modMap.get(time[i] % 60).add(i);
        }
        for (int i = 0; i < 60; i++) {
            {
                List<Integer> indexSet1 = modMap.get(i);
                List<Integer> indexSet2 = i == 0 ? modMap.get(0) : modMap.get(60 - i);
                if (indexSet1 != null && indexSet2 != null) {
                    solution += addPairs(indexSet1, indexSet2);
                }
            }
        }
        return solution;
    }

    private static int addPairs(List<Integer> indexSet1, List<Integer> indexSet2) {
        int solution = 0;
        for (Integer i : indexSet1) {
            int index = 0;
            for (Integer j : indexSet2) {
                if (i < j) {
                    break;
                }
                index++;
            }
            solution += indexSet2.size() - index;
        }
        return solution;
    }

    public static int numPairsDivisibleBy60test3(int[] time) {
        int solution = 0;
        Map<Integer, List<Integer>> modMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            modMap.computeIfAbsent(time[i] % 60, j -> new ArrayList<>());
            modMap.get(time[i] % 60).add(i);
        }
        for (int i = 0; i < 60; i++) {
            {
                List<Integer> indexSet1 = modMap.get(i);
                List<Integer> indexSet2 = i == 0 ? modMap.get(0) : modMap.get(60 - i);
                if (indexSet1 != null && indexSet2 != null) {
                    solution += addPairs3(indexSet1, indexSet2);
                }
            }
        }
        return solution;
    }

    private static int addPairs3(List<Integer> indexSet1, List<Integer> indexSet2) {
        int solution = 0;
        int max = indexSet2.get(indexSet2.size() - 1);
        for (Integer i : indexSet1) {
            if (i > max) {
                break;
            }
            int index = 0;
            for (Integer j : indexSet2) {
                if (i < j) {
                    break;
                }
                index++;
            }
            solution += indexSet2.size() - index;
        }
        return solution;
    }

    public static void main(String[] args) throws Exception {
        int[] time = { 30, 20, 150, 100, 40 };
        int[] time1 = { 60, 60, 60 };
        System.out.println("time: " + numPairsDivisibleBy60test1(time));
        System.out.println("time1: " + numPairsDivisibleBy60test1(time1));

        int[] time2 = new int[60000];
        for (int i = 0; i < time2.length; i++) {
            time2[i] = new Random().nextInt(500);
            // System.out.println("time2: "+ i + " " + time2[i]);
        }
        Date start1 = new Date();
        System.out.println("original: " + numPairsDivisibleBy60(time2));
        System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
        start1 = new Date();
        System.out.println("new function: " + numPairsDivisibleBy60test1(time2));
        System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
        start1 = new Date();
        System.out.println("new function3: " + numPairsDivisibleBy60test3(time2));
        System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
    }
}
