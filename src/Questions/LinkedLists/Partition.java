package Questions.LinkedLists;

import Questions.IQuestion;

public class Partition implements IQuestion {
    @Override
    public void run() {
        Node head = new Node(1).add(2).add(3).add(4).add(5).add(6).add(-1).add(-2);
        System.out.println(head);
        head = partitionOn(head, 3);
        System.out.println(head);
    }

    private static Node partitionOn(Node head, int i) {
        Node gte = null;
        Node lt = null;

        while (head != null) {
            if (head.data >= i) {
                Node n = head;
                head = head.next;

                n.next = gte;
                gte = n;
            } else {
                Node n = head;
                head = head.next;

                n.next = lt;
                lt = n;
            }
        }

        if (lt == null) {
            return gte;
        }

        Node n = lt;
        while (n.next != null) {
            n = n.next;
        }
        n.next = gte;

        return lt;
    }
}
