package Questions.LinkedLists;

import Questions.IQuestion;

public class SumLists implements IQuestion {
    @Override
    public void run() {
        Node n1 = new Node(7).add(1).add(6);
        Node n2 = new Node(5).add(9).add(2);
        System.out.println(n1 + " + " + n2);
        Node sum = sum(n1, n2);
        System.out.println(sum);
    }

    private static Node sum(Node n1, Node n2) {
        int i1 = getNumber(n1);
        int i2 = getNumber(n2);
        int sum = i1 + i2;
        return numberToNode(sum);
    }

    private static int getNumber(Node n) {
        int pow = 0;
        int sum = 0;
        while (n != null) {
            sum += n.data * Math.pow(10, pow++);
            n = n.next;
        }
        return sum;
    }

    private static Node numberToNode(int i) {
        Node head = null;
        while ( i > 0 ) {
            int mod = i % 10;
            i /= 10;
            if (head == null) {
                head = new Node(mod);
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = new Node(mod);
            }
        }
        return head;
    }
}
