import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2020-01-03-20:11
 */
public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    static public ListNode reverseList(ListNode head) {
        int count=0;
        ListNode temp=head;
        ListNode head2=new ListNode(0);
        ListNode temp2=head2;
        ArrayList<Integer> al=new ArrayList<>();
        while(temp!=null){
            al.add(temp.val);
            temp=temp.next;
        }
        Collections.reverse(al);
        for(Integer i:al){
            temp2.next=new ListNode(i);
            temp2=temp2.next;
        }
        return head2.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(3);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(5);
        ListNode l=ReverseLinkedList.reverseList(head);
        System.out.println();
    }
}
