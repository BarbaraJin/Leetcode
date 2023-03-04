package LinkedList.Medium;

import java.util.*;

import print.*;

public class LinkedListCycleII142 {

    public static ListNode detectCycle(ListNode head) {
        ListNode meetPoint = getNodeInCycle(head);
        if (meetPoint != null) {
            ListNode cur = head;
            while (cur != meetPoint) {
                cur = cur.next;
                meetPoint = meetPoint.next;
            }
            return cur;
        }
        return meetPoint;
    }

    // private static boolean isInCycle(ListNode cur, ListNode nodeInCycle) {
    // ListNode begin = null;
    // while (nodeInCycle != begin) {
    // if (cur == nodeInCycle) {
    // return true;
    // }
    // if (begin == null) {
    // begin = nodeInCycle;
    // }
    // nodeInCycle = nodeInCycle.next;
    // }
    // return false;
    // }

    public static ListNode getNodeInCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            try {
                slow = slow.next;
                fast = fast.next.next;
            } catch (Exception e) {
                return null;
            }
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        int[] input = { 3, 2, 0, -4 };
        int[] input3 = { 1 };
        int[] input4 = {};
        int[] input1 = { 1, 2 };

        ListNode a = ListNode.creatCycleListNode(input, 1);
        ListNode a1 = ListNode.creatListNode(input);
        Print.printListNodeWithLength(a, 6);
        Date start = new Date();
        ListNode answer = detectCycle(a);
        Date end = new Date();
        Print.printListNodeWithLength(answer, 10);
        Print.printRunTime(start, end);
    }
}
