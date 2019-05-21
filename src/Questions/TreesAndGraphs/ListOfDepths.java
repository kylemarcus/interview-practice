package Questions.TreesAndGraphs;

import Questions.IQuestion;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths implements IQuestion {
    @Override
    public void run() {
        BinaryTreeNode head = new BinaryTreeNode(10);
        head.insertLeft(5);
        head.left.insertLeft(3);
        head.left.insertRight(6);
        head.insertRight(20);
        head.right.insertLeft(15);
        head.right.insertRight(25);

        ArrayList<LinkedList<BinaryTreeNode>> depthList = new ArrayList<>();
        createDepthList(head, depthList, 0);
    }

    private static void createDepthList(BinaryTreeNode head, ArrayList<LinkedList<BinaryTreeNode>> depthList, int currentDepth) {
        if (head == null) return;
        if (currentDepth >= depthList.size()) {
            depthList.add(currentDepth, new LinkedList<>());
        }
        LinkedList<BinaryTreeNode> ll = depthList.get(currentDepth);
        ll.add(head);
        createDepthList(head.left, depthList, currentDepth + 1);
        createDepthList(head.right, depthList, currentDepth + 1);
    }
}
