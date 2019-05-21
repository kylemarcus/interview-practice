package Questions.java2blog;

import Questions.IQuestion;

public class LinkedList<T> implements IQuestion {
    @Override
    public void run() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
        ll.reverse();
        System.out.println(ll);
    }

    class Node {
        T value;
        Node next;
        public Node(T v) {
            value = v;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(T t) {
        if (head == null) {
            head = new Node(t);
            return;
        }

        Node runner = head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(t);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node runner = head;
        while (runner != null) {
            sb.append(runner.value).append(" -> ");
            runner = runner.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverse() {
        head = reverseRecursive(head);
    }

    private Node reverseRecursive(Node n) {
        if (n == null || n.next == null) {
            return n;
        }

        Node reversed = reverseRecursive(n.next);
        n.next.next = n;
        n.next = null;
        return reversed;
    }

    private Node reverseIterative(Node current) {
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}