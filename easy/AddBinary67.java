package easy;

import java.util.Date;

public class AddBinary67 {

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int al = a.length(), bl = b.length();
        char[] anc = al > bl ? a.toCharArray() : b.toCharArray();
        int c = anc.length - 1;
        char f = '0';
        // boolean ao = false;
        for (int i = al - 1, j = bl - 1; c > -1; i--, j--, c--) {
            char ai = i < 0 ? '0' : a.charAt(i), bi = j < 0 ? '0' : b.charAt(j);
            if (ai == '0' && bi == '0') {
                anc[c] = f;
                f = '0';
            } else if (ai == '0' || bi == '0') {
                anc[c] = f == '0' ? '1' : '0';
            } else {
                anc[c] = f;
                f = '1';
            }
            if ((i <= 0 || j <= 0) && f == '0') {
                return String.valueOf(anc);
            }
        }
        if (f == '1') {
            ans.append(f);
            ans.append(anc);
            return ans.toString();
        }
        return ans.toString();
    }

    public static void main(String[] args) throws Exception {
        String a = "11111";
        String b = "11111";
        Date start = new Date();
        String answer = addBinary(a, b);
        Date end = new Date();
        System.out.println(answer);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    // private static String printAnswer(List<List<Integer>> answer) {
    // StringJoiner print = new StringJoiner("\n");
    // for (List<Integer> list : answer) {
    // StringJoiner sj = new StringJoiner(",");
    // for (Integer list2 : list) {
    // sj.add(String.valueOf(list2));
    // }
    // print.merge(sj);
    // }
    // return print.toString();
    // }
}
