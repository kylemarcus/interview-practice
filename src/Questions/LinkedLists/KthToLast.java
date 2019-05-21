package Questions.LinkedLists;

import Questions.IQuestion;

public class KthToLast implements IQuestion {
    @Override
    public void run() {
        Node head = new Node(1).add(2).add(3).add(4).add(1);
        System.out.println(head);
        Node n = find(head, 3);
        System.out.println(head);
        System.out.println(n.data);
    }

    private static Node find(Node head, int k) {
        Node runner = head;
        for(int i=0; i<k; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            runner = runner.next;
            head = head.next;
        }

        return head;
    }
}
