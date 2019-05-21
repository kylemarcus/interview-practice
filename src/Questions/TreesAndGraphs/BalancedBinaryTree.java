package Questions.TreesAndGraphs;

import Questions.IQuestion;

public class BalancedBinaryTree implements IQuestion {

    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(1);
        root.insertRight(1);
        root.right.insertRight(1);
        root.right.right.insertRight(1);

        boolean isSuperbalanced = isSuperbalancedRefactored(root);
        System.out.println(isSuperbalanced);
    }

    private boolean isSuperbalancedRefactored(BinaryTreeNode root) {
        CompareDepth max = (i, j) -> Math.max(i, j);
        int maxDepth = depth(root, max);
        CompareDepth min = (i, j) -> Math.min(i, j);
        int minDepth = depth(root, min);
        System.out.println("max: " + maxDepth + ", min: " + minDepth);
        return maxDepth - minDepth <= 1;
    }

    private boolean isSuperbalanced(BinaryTreeNode root) {
        int maxDepth = maxDepth(root);
        int minDepth = minDepth(root);
        System.out.println("max: " + maxDepth + ", min: " + minDepth);
        return maxDepth - minDepth <= 1;
    }

    private int depth(BinaryTreeNode n, CompareDepth c) {
        if (n == null) return 0;

        int leftDepth = depth(n.left, c) + 1;
        int rightDepth = depth(n.right, c) + 1;

        return c.compare(leftDepth, rightDepth);
    }

    private int maxDepth(BinaryTreeNode n) {
        if (n == null) return 0;

        int leftDepth = maxDepth(n.left) + 1;
        int rightDepth = maxDepth(n.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    private int minDepth(BinaryTreeNode n) {
        if (n == null) return 0;

        int leftDepth = minDepth(n.left) + 1;
        int rightDepth = minDepth(n.right) + 1;

        return Math.min(leftDepth, rightDepth);
    }

    interface CompareDepth {
        public int compare(int i, int j);
    }
}
