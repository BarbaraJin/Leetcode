package LinkedList.Medium;

import java.util.Date;

import print.*;

public class OddEvenLinkedList328 {

    public static ListNode oddEvenList1(ListNode head) {
        try {
            ListNode odd = head;
            ListNode evenHead = head.next;
            ListNode even = head.next;
            ListNode next = head.next.next;
            for (boolean o = true; next != null; o = !o) {
                if (o) {
                    odd.next = next;
                    odd = odd.next;
                } else {
                    even.next = next;
                    even = even.next;
                }
                next = next.next;
            }
            odd.next = evenHead;
            even.next = null;
        } catch (Exception e) {
            return head;
        }
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        try {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            even.next = null;
        } catch (Exception e) {
            return head;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        int[] input5 = { 3, 2, 0, -4 };
        int[] input2 = { 1 };
        int[] input3 = {};
        int[] input1 = { 1, 2 };
        int[] input = { 2, 1, 3, 5, 6, 4, 7 };

        ListNode a = ListNode.creatListNode(input);
        Date start = new Date();
        ListNode answer = oddEvenList(a);
        Date end = new Date();
        Print.printListNode(answer);
        Print.printRunTime(start, end);
    }
}
