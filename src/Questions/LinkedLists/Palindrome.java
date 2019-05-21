package Questions.LinkedLists;

import Questions.IQuestion;

public class Palindrome implements IQuestion {
    @Override
    public void run() {
        Node n = new Node(5).add(9).add(2).add(9).add(5);
        System.out.println(n);
        boolean b = isPalindrome(n);
        System.out.println(b);
    }

    private static boolean isPalindrome(Node n) {
        int head = 0;
        int tail = getLength(n);

        while (head < tail) {
            Node headNode = n;
            Node tailNode = n;

            for(int i=0; i<head; i++) {
                headNode = headNode.next;
            }

            for(int i=0; i<tail; i++) {
                tailNode = tailNode.next;
            }

            if (headNode.data != tailNode.data) {
                return false;
            }

            head ++;
            tail --;
        }

        return true;
    }

    private static int getLength(Node head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter - 1;
    }
}
