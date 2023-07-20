package print;

import java.util.*;

public class Print {
    public static void printListInteger(List<Integer> answer) {
        StringJoiner print = new StringJoiner(",");
        for (int i : answer) {
            print.add(String.valueOf(i));
        }
        System.out.println(print.toString());
    }

    public static void printArrayInteger(int[] answer) {
        StringJoiner print = new StringJoiner(",");
        for (int i : answer) {
            print.add(String.valueOf(i));
        }
        System.out.println(print.toString());
    }

    public static void printArrayBigInteger(Integer[] answer) {
        StringJoiner print = new StringJoiner(",");
        for (Integer i : answer) {
            print.add(i == null ? "null" : Integer.toString(i));
        }
        System.out.println(print.toString());
    }

    public static void printListOfListInteger(List<List<Integer>> answer) {
        StringJoiner print = new StringJoiner("\n");
        for (List<Integer> list : answer) {
            StringJoiner sj = new StringJoiner(",");
            for (Integer list2 : list) {
                sj.add(String.valueOf(list2));
            }
            print.merge(sj);
        }
        System.out.println(print.toString());
    }

    public static void printListNode(ListNode node) {
        if (node == null) {
            print("null");
        }
        StringJoiner print = new StringJoiner("->");
        while (node != null) {
            print.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(print.toString());
    }

    public static void printListNodeWithLength(ListNode node, int length) {
        if (node == null) {
            print("null");
        }
        StringJoiner print = new StringJoiner("->");
        for (int i = 0; node != null && i < length; i++) {
            print.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(print.toString());
    }

    public static void printTreeNode(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", node);
        System.out.print(sb.toString());
    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {

        sb.append(padding);
        sb.append(pointer);
        sb.append(node != null ? String.valueOf(node.val) : "null");
        sb.append("\n");

        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  ");
        if (node != null && (node.left != null || node.right != null)) {
            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = "├──";
            // String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }

    public static void printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", node);
        System.out.print(sb.toString());
    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {

        sb.append(padding);
        sb.append(pointer);
        sb.append(node != null ? String.valueOf(node.val) : "null");
        sb.append("\n");

        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  ");
        if (node != null && (node.child != null || node.next != null)) {
            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = "├──";
            // String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.child);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.next);
        }
    }

    public static void printRunTime(Date start, Date end) {
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    public static void print(Object print) {
        if (print instanceof String) {
            System.out.println("'" + print + "'");
        } else {
            System.out.println(print);
        }
    }
}
