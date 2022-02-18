package medium;

import java.util.*;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<List<Integer>, Integer> cMap = new HashMap<>();
        for (int c : candidates) {
            Map<List<Integer>, Integer> toAdd = new HashMap<>();
            for (int i = 0; i * c <= target; i++) {
                List<Integer> ic = new ArrayList<>();
                for (int j = 1; j <= i; j++) {
                    ic.add(c);
                }
                int sum = i * c;
                if (sum == target) {
                    answer.add(ic);
                } else if (i != 0) {
                    toAdd.put(ic, sum);
                    for (Map.Entry<List<Integer>, Integer> entry : cMap.entrySet()) {
                        List<Integer> key = entry.getKey();
                        List<Integer> subA = new ArrayList<>(key);
                        subA.addAll(ic);
                        int subASum = entry.getValue() + sum;
                        if (subASum == target) {
                            answer.add(subA);
                        } else if (subASum < target) {
                            toAdd.put(subA, subASum);
                        }
                    }
                }

            }
            cMap.putAll(toAdd);
        }
        return answer;
    }

    // ====================== faster answer ==================================
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), 0, answer);
        return answer;
    }

    private static void helper(int[] candidates, int target, int i, List<Integer> curList, int curSum,
            List<List<Integer>> answer) {
        if (curSum == target && !curList.isEmpty()) {
            answer.add(curList);
            return;
        }
        if(curSum>target){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            int c = candidates[j];
            if(c<=target){
                List<Integer> subList = new ArrayList<>(curList);
                subList.add(c);
                helper(candidates, target, j, subList, curSum+c, answer);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] c0 = new int[] {2,3,5, 7, 9 ,11,15};
        int t0 = 15;
        Date start = new Date();
        List<List<Integer>> answer = combinationSum2(c0, t0);
        Date end = new Date();
        System.out.println(printAnswer(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printAnswer(List<List<Integer>> answer) {
        StringJoiner print = new StringJoiner("\n");
        for (List<Integer> list : answer) {
            StringJoiner sj = new StringJoiner(",");
            for (Integer list2 : list) {
                sj.add(String.valueOf(list2));
            }
            print.merge(sj);
        }
        return print.toString();
    }
}
