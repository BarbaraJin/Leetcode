package LinkedList.easy;

import java.util.Date;

import print.*;

public class MergeTwoSortedLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode cur = null;
        ListNode i = list1, j = list2;
        for (; i != null && j != null;) {
            ListNode temp = null;
            if (i.val <= j.val) {
                temp = i;
                i = i.next;
            } else {
                temp = j;
                j = j.next;
            }
            if (head == null) {
                head = temp;
                cur = head;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        if (i == null) {
            cur.next = j;
        } else {
            cur.next = i;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        int[] i1 = {-100,0,1,2,3,4,10  };
        int[] i2 = { -100,0,100};

        ListNode a = ListNode.creatListNode(i1);
        ListNode b = ListNode.creatListNode(i2);
        Date start = new Date();
        ListNode answer = mergeTwoLists(a, b);
        Date end = new Date();
        Print.printListNode(a);
        Print.printRunTime(start, end);
    }
}
