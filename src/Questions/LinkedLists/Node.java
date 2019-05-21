package Questions.LinkedLists;

public class Node {
    Node next;
    int data;
    Node(int i) {
        data = i;
    }
    Node add(int i) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(i);
        return this;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node runner = this;
        while (runner != null) {
            sb.append(runner.data).append(" -> ");
            runner = runner.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
