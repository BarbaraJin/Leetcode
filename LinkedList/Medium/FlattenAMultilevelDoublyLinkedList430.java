package LinkedList.Medium;

import java.util.Date;

import print.ListNode;
import print.Node;
import print.Print;

public class FlattenAMultilevelDoublyLinkedList430 {

    public static Node flatten(Node head) {
        Node answer = head;
        Node curNext = null;
        while (head != null) {
            Node child = head.child;
            if (child != null) {
                curNext = head.next;
                head.next = flatten(child);
                child.prev = head;
                head.child = null;
            }
            if (head.next == null && curNext != null) {
                head.next = curNext;
                curNext.prev = head;
                curNext = null;
            }
            head = head.next;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] input = { 3, 2, 0, -4 };
        int[] input3 = { 1 };
        int[] input4 = {};
        int[] input1 = { 1, 2 };

        Node a = Node.createNode(input);
        a = Node.addChildren(a, Node.createNode(input1), 1);
        Print.printNode(a);
        Date start = new Date();
        Node answer = flatten(a);
        Date end = new Date();
        Print.printNode(answer);
        Print.printRunTime(start, end);
    }
}
