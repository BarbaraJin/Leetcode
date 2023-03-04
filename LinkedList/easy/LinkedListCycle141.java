package LinkedList.easy;

import java.util.*;

import print.*;

public class LinkedListCycle141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int[] input1 = { 3, 2, 0, -4 };
        int[] input = { 1,2};

        ListNode a = ListNode.creatCycleListNode(input, 0);
        ListNode a1 = ListNode.creatListNode(input);
        Print.printListNodeWithLength(a, 6);
        Date start = new Date();
        boolean answer = hasCycle(a);
        Date end = new Date();
        Print.print(answer);
        Print.printRunTime(start, end);
    }
}
