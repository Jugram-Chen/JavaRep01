///**
// * @author Donglin Chen
// * @create 2019-12-18-17:09
// */
//public class LRUCache {
//    static class Node {//创建节点类
//
//        int key;
//        int value;
//        Node next;
//        Node pre;
//
//        Node() {
//        }
//
//        Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    static class DoubleLinkedList {//创建双向链表
//
//        Node head;
//        Node tail;
//        int size = 0;
//
//        public DoubleLinkedList() {
//        }
//
//        public void addStart(int key, int value) {
//            Node temp = new Node(key, value);
//            if (head == null && tail == null) {
//                head = temp;
//                tail = temp;
//            } else {
//                head.pre = temp;
//                temp.pre = null;
//                temp.next = head;
//                head = temp;
//            }
//            size++;
//            if(size==1)
//                return;
//            temp=head.next;
//            while(true){
//                if(temp.key==key) {
//                    temp.pre.next = temp.next;
//                    temp.next.pre = temp.pre;
//                    size--;
//                    break;
//                }
//                if(temp.next==null)
//                    break;
//            }
//        }
//
//        public void removeEnd() {
//            if (head == null)
//                return;
//            else if (head == tail) {
//                head = null;
//                tail = null;
//            } else {
//                tail = tail.pre;
//                tail.next = null;
//            }
//            size--;
//        }
//
//        public int getValue(int key) {
//            if (head == null)
//                return -1;
//            else {
//                Node temp = head;
//                while (true) {
//                    if (key == temp.key) {
//                        if (temp == head)
//                            return temp.value;
//                        else if (temp == tail) {
//                            addStart(temp.key, temp.value);
//                            temp.pre.next = null;
//                            tail = temp.pre;
//                            size--;
//                            return temp.value;
//                        } else {
//                            addStart(temp.key, temp.value);
//                            temp.pre.next = temp.next;
//                            temp.next.pre = temp.pre;
//                            size--;
//                            return temp.value;
//                        }
//                    }
//                    if (temp.next == null)
//                        break;
//                    temp = temp.next;
//                }
//                return -1;
//            }
//        }
//
//        public void print() {
//            Node temp = head;
//            while (true) {
//                System.out.println("[" + temp.key + " , " + temp.value + "]");
//                if (temp.next == null)
//                    break;
//                temp = temp.next;
//            }
//        }
//    }
//
//    int capacity;
//    DoubleLinkedList dbl = new DoubleLinkedList();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return dbl.getValue(key);
//    }
//
//    public void put(int key, int value) {
//        if (capacity > dbl.size)
//            dbl.addStart(key, value);
//        else {
//            dbl.addStart(key, value);
//            if(capacity<dbl.size)
//            dbl.removeEnd();
//        }
//    }
//
//    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2 /* capacity */);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//    }
//}


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}