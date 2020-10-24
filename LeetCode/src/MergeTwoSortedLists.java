/**
 * @author Donglin Chen
 * @create 2019-12-25-20:22
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, start, p3;
        start = new ListNode(-1, null);
        p3 = start;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3.next = new ListNode(p1.val, null);
                p1 = p1.next;
                p3 = p3.next;
            } else if (p1.val > p2.val) {
                p3.next = new ListNode(p2.val, null);
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        if (p2 == null) {
            while (p1 != null) {
                p3.next = new ListNode(p1.val, null);
                p1 = p1.next;
                p3 = p3.next;
            }
        } else if (p1 == null) {
            while (p2 != null) {
                p3.next = new ListNode(p2.val, null);
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        return start.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
