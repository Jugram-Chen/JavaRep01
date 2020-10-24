import java.util.ArrayList;
import java.util.HashMap;

public class CopyListwithRandomPointer {
    HashMap<Node,Node> hm=new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node head2=new Node(head.val);
        Node p0=head;
        Node p1=head;
        Node p2=head2;
        Node p3=head2;
        hm.put(head,head2);
//        ArrayList<Node> al=new ArrayList<>();
//        al.add(head);
        while(p1.next!=null){
            Node temp=new Node(p1.next.val);
            p2.next=temp;
            hm.put(p1.next,temp);
            p2=p2.next;
            p1=p1.next;
        }
        p2.next=null;
        while(p0!=null){
            Node temp1=hm.get(p0);
            Node temp2=p0.random;
            temp1.random=hm.get(temp2);
            p0=p0.next;
        }
        return p3;
    }


    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        n1.next=n2;
        n1.random=n2;
        n2.next=null;
        n2.random=n2;
        Node result=new CopyListwithRandomPointer().copyRandomList(n1);
        System.out.println(result);
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
