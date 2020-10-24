/**
 * @author Donglin Chen
 * @create 2019-12-16-17:18
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode p=l1;
        ListNode q=l2;
        ListNode cur=head;
        int carry=0;
        while(p!=null||q!=null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum=carry+x+y;
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry>0)
            cur.next=new ListNode(1);
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("bbb");
    }
}
