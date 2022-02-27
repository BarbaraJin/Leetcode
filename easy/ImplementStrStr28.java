package easy;

public class ImplementStrStr28 {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int s = -1, nl = needle.length() - 1, hl = haystack.length();
        for (int i = 0; i < hl && s == -1; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + nl < hl &&
                    haystack.charAt(i + nl) == needle.charAt(nl)) {
                s = i;
                int end = i + nl;
                for (int k = i + 1; k < end; k++) {
                    if (haystack.charAt(k) != needle.charAt(k - i)) {
                        s = -1;
                        break;
                    }
                }
            }
        }
        return s;
    }

    public static int strStrAnswer(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) throws Exception {
        String h = "babba";
        String n = "bbb";
        Long start = System.nanoTime();
        int answer = strStr(h, n);
        Long end = System.nanoTime();
        Long start1 = System.nanoTime();
        int answer1 = strStrAnswer(h, n);
        Long end1 = System.nanoTime();
        System.out.println(answer);
        System.out.println("run time: " + (end - start));
        System.out.println(answer1);
        System.out.println("run time: " + (end1 - start1));
    }

    // private String printAnswer(int[] answer) {
    //     StringJoiner print = new StringJoiner("");
    //     for (int a : answer) {
    //         print.add(String.valueOf(a));
    //     }
    //     return print.toString();
    // }
}
