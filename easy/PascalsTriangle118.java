package easy;

import java.util.*;

public class PascalsTriangle118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if(i == 0){
                answer.add(getRow(new ArrayList<>()));
            }else{
                answer.add(getRow(answer.get(i-1)));
            }
        }
        return answer;
    }
    
    private static List<Integer> getRow(List<Integer> list) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            if(i==0 || i==list.size()){
                answer.add(1);
            }else{
                answer.add(list.get(i-1)+list.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int r = 1;
        Date start = new Date();
        List<List<Integer>> answer = generate(r);
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
