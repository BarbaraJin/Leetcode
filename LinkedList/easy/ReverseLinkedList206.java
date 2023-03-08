package LinkedList.easy;

import java.util.*;

import print.*;

public class ReverseLinkedList206 {
    public static ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode next = head;
            head = head.next;
            next.next = last;
            last = next;
        }
        return last;
    }

    public static void main(String[] args) throws Exception {
        // int[] input1 = { 3, 2, 0, -4 };
        int[] input = { 1,2,3,4 };

        ListNode a = ListNode.creatListNode(input);
        Date start = new Date();
        ListNode answer = reverseList(a);
        Print.printListNode(answer);
        Print.printRunTime(start, new Date());
    }
}
