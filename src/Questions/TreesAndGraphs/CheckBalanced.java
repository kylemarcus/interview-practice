package Questions.TreesAndGraphs;

import Questions.IQuestion;

public class CheckBalanced implements IQuestion {
    @Override
    public void run() {
        BinaryTreeNode head = new BinaryTreeNode(10);
        head.insertLeft(5);
        head.insertRight(20);
        head.left.insertLeft(3);
        head.left.insertRight(6);
        head.right.insertLeft(15);
        head.right.insertRight(25);
        head.left.left.insertLeft(2);
        //head.left.left.insertLeft(1);

        boolean b = isBalanced(head);
        System.out.println(b);
    }

    private static boolean isBalanced(BinaryTreeNode n) {
        if (n == null) return true;

        int l = height(n.left);
        int r = height(n.right);

        return (Math.abs(l-r) <= 1);
    }

    private static int height(BinaryTreeNode n) {
        if (n == null) return 0;

        int l = height(n.left) + 1;
        int r = height(n.right) + 1;

        return Math.max(l, r);
    }
}
