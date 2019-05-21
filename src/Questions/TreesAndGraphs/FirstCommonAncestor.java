package Questions.TreesAndGraphs;

import Questions.IQuestion;

import java.util.Stack;

public class FirstCommonAncestor implements IQuestion {
    @Override
    public void run() {

    }

    private static BinaryTreeNode FirstCommonAncestor(BinaryTreeNode head, BinaryTreeNode n1, BinaryTreeNode n2) {

        Stack<BinaryTreeNode> stack1 = getPath(head, n1);
        Stack<BinaryTreeNode> stack2 = getPath(head, n2);

        BinaryTreeNode lca = null;
        while (!stack1.empty() && !stack1.empty()) {
            if (stack1.peek() != stack2.peek()) {
                return lca;
            }
            lca = stack1.pop();
            stack2.pop();
        }

        return lca;
    }

    private static Stack<BinaryTreeNode> getPath(BinaryTreeNode head, BinaryTreeNode n) {
        // base case
        if (head == null) return null;
        if (head == n) {
            Stack<BinaryTreeNode> s = new Stack<>();
            s.push(n);
            return s;
        }

        // recursive case
        Stack<BinaryTreeNode> s = getPath(n.left, n);
        if (s != null) {
            s.push(head);
            return s;
        }

        s = getPath(n.right, n);
        if (s != null) {
            s.push(head);
            return s;
        }

        return null;
    }
}
