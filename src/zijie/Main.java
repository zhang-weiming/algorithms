package zijie;


public class Main {

    static class Node {
        private int data;// 数据域
        public Node next;// 指针域

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int Data) {
            this.data = Data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node Next) {
            this.next = Next;
        }
    }

    static Node reverseK(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        Node newHead = null;
        Node lastHead = null;
        Node thisHead = null;

        Node crt = head;
        Node nex = null;
        Node pre = null;

        while (crt != null) {
            int i = 0;
            thisHead = crt;

            while (i++ < k && crt != null) {
                nex = crt.getNext();
                crt.setNext(pre);
                pre = crt;
                crt = nex;
            }
            Node thisTail = pre;

            if (newHead == null) {
                newHead = thisTail;
            }

            if (lastHead != null) {
                lastHead.next = thisTail;
            }

            lastHead = thisHead;
        }
        lastHead.setNext(null);

        return newHead;
    }

    public static void printNodes(Node head) {
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node pre = head;
        for (int i = 2; i < 9; i++) {
            Node node = new Node(i);
            pre.next = node;
            pre = node;
        }
        printNodes(head);
        Node result = reverseK(head, 3);
        System.out.println();
        printNodes(result);
    }
}