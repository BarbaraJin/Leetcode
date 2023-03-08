package LinkedList.Medium;

import java.util.*;

import print.*;

public class RemoveNthNodeFromEndOfList19 {
    // public static ListNode removeNthFromEnd(ListNode head, int n) {
    // ListNode answer = head;
    // Map<Integer, ListNode> indexMap = new HashMap<>();
    // int l = 0;
    // while (head != null) {
    // indexMap.put(l++, head);
    // head = head.next;
    // }
    // int k = l - n - 1;
    // if (k < 0) {
    // return indexMap.getOrDefault(1, null);
    // } else {
    // indexMap.get(k).next = indexMap.get(k).next != null ?
    // indexMap.get(k).next.next : null;
    // }
    // return answer;
    // }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) throws Exception {
        int[] input1 = { 3, 2, 0, -4 };
        int[] input = { 1,2,3,4,5 };

        ListNode a = ListNode.creatListNode(input);
        Date start = new Date();
        ListNode answer = removeNthFromEnd(a, 2);
        Print.printListNode(answer);
        Print.printRunTime(start, new Date());
    }
}
