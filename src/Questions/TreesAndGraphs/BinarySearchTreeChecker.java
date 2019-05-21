package Questions.TreesAndGraphs;

import Questions.IQuestion;

import java.util.Stack;

public class BinarySearchTreeChecker implements IQuestion {
    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(25);
        root.insertLeft(15);
        root.left.insertLeft(2);
        //root.left.insertRight(30);
        root.insertRight(50);
        boolean isBst = isBst(new NodeWithBounds(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(isBst);
    }

    private class NodeWithBounds {
        public int upperBound;
        public int lowerBound;
        public BinaryTreeNode root;
        public NodeWithBounds(BinaryTreeNode node, int upperBound, int lowerBound) {
            this.root = node;
            this.upperBound = upperBound;
            this.lowerBound = lowerBound;
        }
    }

    private boolean isBst(NodeWithBounds nodeBounds) {
        Stack<NodeWithBounds> s = new Stack();
        s.push(nodeBounds);

        while(!s.empty()) {
            NodeWithBounds n = s.pop();

            if (n.root.value >= n.upperBound || n.root.value <= n.lowerBound) {
                return false;
            }

            if (n.root.left != null) {
                s.push(new NodeWithBounds(n.root.left, n.root.value, n.lowerBound));
            }

            if (n.root.right != null) {
                s.push(new NodeWithBounds(n.root.right, n.upperBound, n.root.value));
            }
        }

        return true;
    }
}
