package DepthBreadthFirstSearch.easy;

import java.util.Date;

import print.Print;
import print.TreeNode;

public class IsSameTree100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        TreeNode e = new TreeNode(1, null, new TreeNode(2));
        TreeNode f = new TreeNode(1, new TreeNode(2), null);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        Date start = new Date();
        boolean answer = isSameTree(a, b);
        Date end = new Date();

        Print.printTreeNode(e);
        System.out.println(answer);
        Print.printTreeNode(f);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
