package LinkedList.easy;

import java.util.Date;

import print.ListNode;
import print.Print;

public class IntersectionOfTwoLinkedLists160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int al = checkLength(headA);
        int bl = checkLength(headB);
        if (al > bl) {
            headA = getNodeAtInd(headA, al - bl);
        } else {
            headB = getNodeAtInd(headB, bl - al);
        }
        try {
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
        } catch (Exception e) {
            return null;
        }
        return headA;
    }

    private static ListNode getNodeAtInd(ListNode node, int index) {
        ListNode answer = node;
        if (node == null || index == 0) {
            return answer;
        }
        if (index == -1) {
            index = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= index; i++) {
            if (answer.next != null) {
                answer = answer.next;
            } else {
                return answer;
            }
        }
        return answer;
    }

    private static int checkLength(ListNode headA) {
        ListNode temp = headA;
        int l = 0;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        int[] input1 = { 3, 1, 0 };
        int[] input2 = { 3 };
        int[] input3 = { 3 };

        ListNode a = ListNode.creatListNode(input1);
        ListNode b = ListNode.creatListNode(input2);
        ListNode c = ListNode.creatListNode(input3);
        ListNode.addAtTail(a, c);
        ListNode.addAtTail(b, c);

        Date start = new Date();
        ListNode answer = getIntersectionNode(a, a);
        Date end = new Date();
        Print.printListNode(a);
        Print.printListNode(b);
        Print.printListNode(answer);
        Print.printRunTime(start, end);
    }
}
