package LinkedList.easy;

import java.util.*;
import print.*;

public class RemoveLinkedListElement203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == val) {
                continue;
            }
            if (prev == null) {
                prev = cur;
                head = prev;
            } else {
                prev.next = cur;
                prev = prev.next;
            }
        }
        try {
            prev.next = null;
        } catch (Exception e) {
            return prev;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        // int[] input1 = { 3, 2, 0, -4 };
        int[] input = { 1, 1, 1, 1, 1, 1, 1, 1,2,3};

        ListNode a = ListNode.creatListNode(input);
        Date start = new Date();
        ListNode answer = removeElements(a, 1);
        Print.printListNode(answer);
        Print.printRunTime(start, new Date());
    }
}
