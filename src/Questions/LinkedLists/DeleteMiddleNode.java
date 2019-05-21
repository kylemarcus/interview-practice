package Questions.LinkedLists;

import Questions.IQuestion;

public class DeleteMiddleNode implements IQuestion {
    @Override
    public void run() {
        Node head = new Node(1).add(2).add(3).add(4);
        System.out.println(head);
        delete(head.next);
        System.out.println(head);
    }

    public static void delete(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }
}
