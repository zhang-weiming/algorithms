package nowcoder;

public class Jz14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode ptr1 = head, ptr2 = head;
        int i = 0;
        while (i < k && ptr2 != null) {
            ptr2 = ptr2.next;
            i++;
        }
        if (i < k) {
            return null;
        }

        while (ptr2 != null) {
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        return ptr1;
    }
}
