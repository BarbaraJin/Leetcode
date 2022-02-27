package easy;

public class ReverseString344 {

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String h = "a";
        char[] s = h.toCharArray();
        Long start = System.nanoTime();
        reverseString(s);
        Long end = System.nanoTime();
        System.out.println(String.valueOf(s));
        System.out.println("run time: " + (end - start));
    }
}
