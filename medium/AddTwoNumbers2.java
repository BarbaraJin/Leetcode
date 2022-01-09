package medium;

import java.util.Date;
import java.util.Random;

public class AddTwoNumbers2 {
    //final solution
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        int[] node = new int[100];
        int i =-1;
        while (l1 != null || l2 != null || overflow != 0) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + overflow;
            overflow = (int) val / 10;
            node[++i] = val % 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        ListNode answer = null;
        for ( ; i>-1;i--) {
            answer = new ListNode(node[i], answer);
        }
        return answer;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long a = convertToInt(l1);
        long b = convertToInt(l2);
        return createListNode2(a + b);
    }

    private static long convertToInt(ListNode node) {
        long a = 0;
        int index = 0;
        while (node != null) {
            a = (long) (a + node.val * Math.pow(10, index++));
            node = node.next;
        }
        return a;
    }

    public static ListNode createListNode2(long i) {
        if (i == 0) {
            return new ListNode(0);
        }
        int length = ((int) Math.log10(i));
        ListNode node = null;
        while (length >= 0) {
            double help = Math.pow(10, length--);
            int digit = (int) (i / help);
            i = (long) (i - digit * help);
            node = node == null ? new ListNode(digit) : new ListNode(digit, node);
        }
        return node;
    }

    public static ListNode createListNode(int i) {
        int reversei = 0;
        while (i > 0) {
            int digit = i % 10;
            i = (i - digit) / 10;
            reversei = reversei * 10 + digit;
        }
        // ListNode lastNode = null;
        ListNode node = null;
        while (reversei > 0) {
            int digit = reversei % 10;
            reversei = (reversei - digit) / 10;
            node = node == null ? new ListNode(digit) : new ListNode(digit, node);
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        int a = 0;
        int b = 0;
        int lengthA = new Random().nextInt(100);
        int lengthB = new Random().nextInt(100);
        for (int i = 0; i < lengthA; i++) {
            a = a * 10 + new Random().nextInt(10);
        }
        for (int i = 0; i < lengthB; i++) {
            b = b * 10 + new Random().nextInt(10);
        }
        a = Math.abs(a);
        b = Math.abs(b);
        a = 9999999;
        b = 9999;
        ListNode al = createListNode2(a);
        ListNode bl = createListNode2(b);
        Date start = new Date();
        ListNode answer = addTwoNumbers(al, bl);
        Date end = new Date();
        System.out.println("a: " + a + " b: " + b + " a + b: " + (a + b) + " " + printNode(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printNode(ListNode node) {
        StringBuilder test = new StringBuilder();
        while (node != null) {
            test.append(node.val);
            test.append("->");
            node = node.next;
        }
        return test.toString();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
