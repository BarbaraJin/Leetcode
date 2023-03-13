package LinkedList.easy;

import java.util.Date;
import print.*;

public class PalindromeLinkedList234 {
    // public static boolean isPalindrome(ListNode head) {
    // int l = getLength(head);
    // int le = l / 2;
    // int rs = l % 2 == 0 ? le : le + 1;
    // ListNode reverse = null;
    // for (int i = 0; i < l; i++) {
    // if (i < le) {
    // ListNode temp = head;
    // head = head.next;
    // temp.next = reverse;
    // reverse = temp;
    // } else if (i >= rs) {
    // Print.printListNode(reverse);
    // Print.printListNode(head);
    // if (head.val != reverse.val) {
    // return false;
    // } else {
    // head = head.next;
    // reverse = reverse.next;
    // }
    // } else {
    // head = head.next;
    // }
    // }
    // return true;
    // }

    // private static int getLength(ListNode head) {
    // int l = 0;
    // while (head != null) {
    // head = head.next;
    // l++;
    // }
    // return l;
    // }

    public static boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode fast = head.next;
        boolean even = false;
        while (head != null) {
            if (fast != null) {
                ListNode temp = head;
                head = head.next;
                temp.next = reverse;
                reverse = temp;
                even = fast.next == null;
                if (even || fast.next.next == null) {
                    fast = null;
                } else {
                    fast = fast.next.next;
                }
            } else if (even) {
                if (head.val != reverse.val) {
                    return false;
                } else {
                    head = head.next;
                    reverse = reverse.next;
                }
            } else {
                head = head.next;
                even = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int[] input = { 1, 2, 3 };

        ListNode a = ListNode.creatListNode(input);
        Date start = new Date();
        boolean answer = isPalindrome(a);
        Date end = new Date();
        Print.print(answer);
        Print.printRunTime(start, end);
    }
}
