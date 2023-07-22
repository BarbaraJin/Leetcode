package LinkedList.Medium;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.ListNode;
import print.Print;

public class RotateList61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode answer = head;
        List<ListNode> nodeMap = new ArrayList<>();

        int i = 0;
        for (; head != null; i++) {
            nodeMap.add(i, head);
            head = head.next;
        }

        int startInd = i - k % i;
        if (startInd != i) {
            ListNode last = nodeMap.get(startInd - 1);
            last.next = null;
            nodeMap.get(i - 1).next = answer;
            answer = nodeMap.get(startInd);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] input = { 0, 1, 2 };
        int[] input1 = {};

        ListNode a = ListNode.creatListNode(input);
        Print.printListNode(a);
        Date start = new Date();
        ListNode answer = rotateRight(a, 5);
        Date end = new Date();
        Print.printListNode(answer);
        Print.printRunTime(start, end);
    }
}
