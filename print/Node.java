package print;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public static Node createNode(int[] input) {
        Node head = null;
        Node prev = null;
        for (int n : input) {
            if (head == null) {
                head = new Node(n);
                prev = head;
            } else {
                Node node = new Node(n);
                prev.next = node;
                node.prev = prev;
                prev = prev.next;
            }
        }
        return head;
    }

    public static Node addChildren(Node parent, Node child, int i) {
        Node nodeAtInd = getNodeAtInd(parent, i);
        nodeAtInd.child = child;

        return parent;
    }

    private static Node getNodeAtInd(Node node, int index) {
        Node answer = node;
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
};