package Questions.TreesAndGraphs;

import Questions.IQuestion;

public class ValidateBst implements IQuestion {
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
        head.left.left.insertLeft(111);

        boolean b = isBst(head);
        System.out.println(b);
    }

    private static Integer lastSeen = null;
    private static boolean isBst(BinaryTreeNode head) {
        boolean l = true, r = true;
        if (head != null) {
            l = isBst(head.left);

            if (lastSeen != null && lastSeen > head.value) {
                return false;
            } else {
                lastSeen = head.value;
            }

            r = isBst(head.right);
        }

        return l && r;
    }
}
