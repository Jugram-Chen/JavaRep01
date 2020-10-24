
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @Donglin Chen
 */
public class LinkedListHM {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader("EE593\\hw5.dat"));
        SingleLinkedList sll = new SingleLinkedList();
        SingleLinkedList sllEven = new SingleLinkedList();
        while (s.hasNext()) {
            sll.addEnd(s.nextInt());
        }
        int sizeAll = sll.size;
        //int i=4;
        for (int i = sizeAll - 1; i >= 0; i--) {
            if (sll.get(i) % 2 == 0) {
                sllEven.addStart(sll.get(i));
                sll.removePosition(i);
            }
        }
        System.out.println(sll);
        System.out.println(sllEven);
        for (int i = 0; i < sllEven.size; i++) {
            sll.insertPosition(2 * i, sllEven.get(i));
        }
        System.out.println(sll);
    }
}

class Node {
    int value;
    Node next;

    Node() {
    }

    Node(int v, Node n) {
        value = v;
        next = n;
    }
}

class SingleLinkedList {
    int size = 0;
    Node head;

    public void addEnd(int v) {//链表末位添加节点
        Node temp = new Node();
        temp.value = v;
        temp.next = null;
        if (head == null) {
            head = temp;
            size++;
        } else {
            Node temp2 = head;
            //for (temp2 = head; temp2.next != null; temp2 = temp2.next);
            while (temp2.next != null)
                temp2 = temp2.next;
            temp2.next = temp;
            size++;
        }
    }

    public void addStart(int v) {//在链表开头添加节点
        Node temp = new Node();
        temp.value = v;
        temp.next = head;
        head = temp;
        size++;
    }

    public void removeStart() {
        head = head.next;
        size--;
    }

    public void removeEnd() {
        Node temp = head;
        if (size == 0)
            return;
        else if (size == 1) {
            head = null;
            size--;
            return;
        }
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        size--;
    }

    public int get(int position) {
        if (position == 0) {
            return head.value;
        } else if (position >= size)
            return 99999999;
        else {
            Node temp = head;
            for (int i = 0; i < position; i++)
                temp = temp.next;
            return temp.value;
        }
    }

    public void removePosition(int position) {
        if (position == 0)
            this.removeStart();
        else if (position >= this.size)
            this.removeEnd();
        else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++)
                temp = temp.next;
            temp.next = temp.next.next;
            size--;
        }
    }

    public void insertPosition(int position, int v) {
        if (position == 0)
            this.addStart(v);
        else if (position >= this.size)
            this.addEnd(v);
        else {
            Node n = new Node(v, null);
            Node temp = head;
            for (int i = 0; i < position - 1; i++)
                temp = temp.next;
            n.next = temp.next;
            temp.next = n;
            size++;
        }
    }

    public String toString() {//遍历输出
        StringBuilder sb = new StringBuilder(size * 6);
        for (Node p = head; p != null; p = p.next)
            sb.append(p.value).append(' ');
        return "{ " + sb.toString() + "}";
    }
}
