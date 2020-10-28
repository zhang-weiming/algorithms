package nowcoder;

public class Jz16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = list1;
        ListNode ptr1 = list1, ptr2 = list2;
        ListNode pre = null;
        while (ptr1 != null && ptr2 != null) {
            while (ptr1 != null && ptr1.val <= ptr2.val) {
                pre = ptr1;
                ptr1 = ptr1.next;
            }

            if (ptr1 != null) {
                pre.next = ptr2;
                ptr2 = ptr2.next;
                pre = pre.next;
                pre.next = ptr1;
            }
        }

        if (ptr2 != null) {
            pre.next = ptr2;
        }

        return head;
    }
}
