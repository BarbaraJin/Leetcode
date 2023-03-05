package print;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode creatListNode(int[] input) {
        ListNode head = null;
        ListNode prev = null;
        for (int n : input) {
            if (head == null) {
                head = new ListNode(n);
                prev = head;
            } else {
                prev.next = new ListNode(n);
                prev = prev.next;
            }
        }
        return head;
    }

    public static ListNode creatCycleListNode(int[] input, int pos) {
        ListNode head = creatListNode(input);
        if (head == null) {
            return null;
        }
        ListNode tail = getNodeAtInd(head, -1);
        ListNode nodeAtPos = getNodeAtInd(head, pos);
        tail.next = nodeAtPos;
        return head;
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

    public static void addAtTail(ListNode node, int val) {
        ListNode tail = node;
        if (tail == null) {
            node = new ListNode(val);
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new ListNode(val);
    }

    public static void addAtTail(ListNode node, ListNode val) {
        ListNode tail = node;
        if (tail == null) {
            node = val;
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = val;
    }
}