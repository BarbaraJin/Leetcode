package easy;

import java.util.*;

public class RemoveDuplicatesFromSortedList83 {

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> a = new ArrayList<>();

        Integer last = null;
        for (last = head.val; head != null; head = head.next) {
            if (last != head.val) {
                a.add(last);
                last = head.val;
            }
        }
        if (last != null) {
            a.add(last);
        }
        return createListNode(a);
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        List<Integer> a = new ArrayList<>();
        if (head == null) {
            return null;
        }
        int last = head.val;
        a.add(last);
        for (; head != null; head = head.next) {
            if (last != head.val) {
                last = head.val;
                a.add(last);
            }
        }
        return createListNode(a);
    }

    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode a = head;
        if (head == null) {
            return null;
        }
        ListNode b = head.next;
        for (; b != null; b = b.next) {
            if (a.val != b.val) {
                a.next = b;
                a = a.next;
            }
        }
        a.next=null;
        return head;
    }

    private static ListNode createListNode(List<Integer> arr) {
        ListNode a = null;
        for (int i = arr.size() - 1; i > -1; i--) {
            a = new ListNode(arr.get(i), a);
        }
        return a;
    }

    private static ListNode createListNode(int[] arr) {
        ListNode a = null;
        for (int i = arr.length - 1; i > -1; i--) {
            a = new ListNode(arr[i], a);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        int[] i = { -100, -100, -99, -1, -1, 0, 1, 1, 1, 2, 3, 99, 99, 100, 100 };
        int[] i1 = {  };
        ListNode input = createListNode(i1);
        Long start = System.nanoTime();
        ListNode ans = deleteDuplicates3(input);
        Long end = System.nanoTime();
        System.out.println(printAnswer(ans));
        System.out.println("run time: " + (end - start));
    }

    private static String printAnswer(ListNode node) {
        StringJoiner test = new StringJoiner("->");
        while (node != null) {
            test.add(String.valueOf(node.val));
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
