public class RemoveNthNodeFromEndofList {

    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ln1 = head;
        ListNode ln2 = null;
        int length = 0;
        while (ln1 != null) {
            length++;
            ln1 = ln1.next;
        }
        if (length == 1)
            return null;
        if (length - 1 - n == -1)
           return head.next;
        ln1 = head;
        for (int i = 0; i < (length - 1 - n); i++) {
            ln1 = ln1.next;
        }
        ln2 = ln1.next.next;
//        System.out.println(ln2.val);
        ln1.next = ln2;
        return head;
    }
}
