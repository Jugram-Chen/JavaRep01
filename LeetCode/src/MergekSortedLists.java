import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2019-12-26-21:26
 */
public class MergekSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                al.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(al);
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(!al.isEmpty()){
            ans.next=new ListNode(al.get(0));
            ans=ans.next;
            al.remove(0);
        }
        return temp.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists={l1,l2,l3};
        ListNode ans=mergeKLists(lists);
        System.out.println();
    }
}
