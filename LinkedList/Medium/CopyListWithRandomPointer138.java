package LinkedList.Medium;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import print.Node;
import print.Print;

public class CopyListWithRandomPointer138 {
    public static Node copyRandomList(Node head) {
        Node answer = null;
        Map<Node, Node> oTnMap = new HashMap<>();
        answer = copy(oTnMap, head);
        return answer;
    }

    private static Node copy(Map<Node, Node> oTnMap, Node head) {
        if (head == null) {
            return null;
        }
        if (oTnMap.containsKey(head)) {
            return oTnMap.get(head);
        }
        Node answer = new Node(head.val);
        oTnMap.put(head, answer);
        answer.next = copy(oTnMap, head.next);
        answer.child = copy(oTnMap, head.child);
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] input = { 3, 2, 0, -4 };
        int[] input1 = { 1, 2 };

        // Node a = Node.createNode(input);
        // a = Node.addChildren(a, Node.createNode(input1), 1);
        // Print.printNode(a);
        Date start = new Date();
        Node answer = copyRandomList(new Node(0));
        Date end = new Date();
        // Print.printNode(answer);
        Print.printRunTime(start, end);
    }
}
