package Questions.LinkedLists;

import Questions.IQuestion;

import java.util.HashMap;
import java.util.Map;

public class RemoveDups implements IQuestion {
    @Override
    public void run() {
        Node head = new Node(1).add(2).add(3).add(4).add(1);
        System.out.println(head);
        head = removeDupsFromLL(head);
        System.out.println(head);
    }

    private static Node removeDupsFromLL(Node head) {
        Map<Integer, Integer> map = new HashMap<>();
        Node n = head;
        while(n != null) {
            if(map.containsKey(n.data)) {
                map.put(n.data, map.get(n.data) + 1);
            } else {
                map.put(n.data, 1);
            }
            n = n.next;
        }

        Node prev = null;
        n = head;
        while(n != null) {
            Integer i = map.get(n.data);
            if (i > 1) {
                // remove this node
                if (prev == null) {
                    head = head.next;
                    n = head;
                } else {
                    prev.next = n.next;
                    n = n.next;
                }
            } else {
                prev = n;
                n = n.next;
            }
        }

        return head;
    }
}
