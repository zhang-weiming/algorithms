package nowcoder;

import java.util.ArrayList;



class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

//    翻转链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>(0);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        ListNode node = listNode;

        while (node != null) {
            res.add(node.val);
            node = node.next;
        }

        for (int i = 0; i < res.size() / 2; i++) {
            int j = res.size() - 1 - i;
            Integer tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
        }
        return res;
    }
}
