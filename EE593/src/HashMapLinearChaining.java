
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Donglin Chen
 */
public class HashMapLinearChaining {

    class Node {//创建节点类

        String str;
        Node next;
        Node pre;

        Node() {
        }

        Node(String str) {
            this.str = str;
        }
    }

    class DoubleLinkedList {//创建双向链表

        Node head;
        Node tail;
        int size;

        public DoubleLinkedList() {
        }

        public void addStart(String s) {
            Node temp = new Node(s);
            if (head == null && tail == null) {
                head = temp;
                tail = temp;
            } else {
                head.pre = temp;
                temp.pre = null;
                temp.next = head;
                head = temp;
            }
            size++;
        }

        public boolean contains(String s) {
            if (head == null && tail == null)
                return false;
            else {
                Node temp = head;
                for (int i = 0; i < size; i++) {
                    if (temp.str.equals(s))
                        return true;
                    temp = temp.next;
                }
            }
            return false;
        }

        public void remove(String s) {
            if (head.str.equals(s) && size == 1) {
                head = null;
                tail = null;
            } else if (head.str.equals(s) && size == 2) {
                head = head.next;
                tail.pre = null;
            } else if (tail.str.equals(s) && size == 2) {
                tail = tail.pre;
                head.next = null;
            } else {
                Node temp = head;
                for (int i = 0; i < size; i++) {
                    if (temp.str.equals(s)) {
                        temp.pre.next = temp.next;
                        temp.next.pre = temp.pre;
                    }
                    temp = temp.next;
                }
                size--;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Node temp = head; temp != null; temp = temp.next) {
                sb.append(temp.str).append(' ');
            }
            return "{ " + sb.toString() + "}";
        }
    }

    int size;
    DoubleLinkedList[] table;

    public HashMapLinearChaining(int size) {
        this.size = size;
        table = new DoubleLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new DoubleLinkedList();
        }
    }

    public int hashFunc(String s) {
        return s.hashCode() % size;
    }

    public void add(String s) {
        int num = hashFunc(s);
        table[Math.abs(num)].addStart(s);
    }

    public boolean contains(String s) {
        int num = hashFunc(s);
        if (table[Math.abs(num)].contains(s))
            return true;
        return false;
    }

    public void remove(String s) {
        if (!contains(s))
            System.out.println("This word is not in the dictionary!");
        else {
            int num = hashFunc(s);
            table[num].remove(s);
        }
    }

    public void computeHistogram() {
        int[] hist = new int[10];
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < size; j++) {
                if (i <= 8 && table[j].size == i)
                    hist[i]++;
                else if (i == 9 && table[j].size >= i)
                    hist[i]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (hist[i] != 0)
                System.out.println("hist[" + i + "]=" + hist[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashMapLinearChaining hmlc1 = new HashMapLinearChaining(500000);
        hmlc1.add("abc");
        hmlc1.add("abm");
        hmlc1.add("abw");
        hmlc1.add("baw");
        //System.out.println(hmlc1.table[4]);
        //System.out.println(hmlc1.contains("abw"));
        //hmlc1.remove("abm");
        //System.out.println(hmlc1.table[4]);
        System.out.println(hmlc1.table[4].size);
        hmlc1.computeHistogram();

        /*HashMapLinearChaining hmlc2 = new HashMapLinearChaining(500000);
        Scanner sc=new Scanner(new FileReader("dict.txt"));
        while(sc.hasNext()){
            hmlc2.add(sc.next());
        }
        sc=new Scanner(new FileReader("prideandprejudice.txt"));
        int count=0;
        while(sc.hasNext()){
            String s=sc.next();
            if(!hmlc2.contains(s))
                count++;
        }
        System.out.println(count);*/
    }
}
