package print;

import java.util.List;
import java.util.StringJoiner;

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
        StringJoiner print = new StringJoiner("->");
        while (node != null) {
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
            sb.append(node!= null?String.valueOf(node.val):"null");
            sb.append("\n");
            
            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");
            if (node!=null && (node.left != null || node.right != null)) {
            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = "├──";
            // String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }
}
