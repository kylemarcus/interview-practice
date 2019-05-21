package Questions.TreesAndGraphs;

import Questions.IQuestion;

public class MinimalTree implements IQuestion {
    @Override
    public void run() {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        BinaryTreeNode n = createBst(a, 0, a.length - 1);
    }

    private static BinaryTreeNode createBst(int[] a, int s, int e) {
        if (e < s) return null;
        int m = (s+e) / 2;
        BinaryTreeNode head = new BinaryTreeNode(a[m]);
        head.left = createBst(a, s, m - 1);
        head.right = createBst(a, m + 1, e);
        return head;
    }
}
