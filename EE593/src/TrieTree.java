
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Donglin Chen
 */
public class TrieTree {
    class Node {//内部类节点
        boolean isWord;
        int num;
        StringBuilder sb;
        Node[] next;

        Node() {
            next = new Node[26];
            isWord = false;
            num = 0;
            sb = new StringBuilder();
        }

        public void print() {//输出此节点下所有存在的单词
            if (this.isWord == true)
                System.out.println(this.sb);
            for (int i = 0; i < 26; i++) {
                if (this.next[i] != null)
                    this.next[i].print();
            }
        }

        @Override
        public String toString() {
            return "Node{" + "isWord=" + isWord + ", num=" + num + ", sb=" + sb + '}';
        }
    }

    Node root;

    public TrieTree() {
        root = new Node();
    }

    public void add(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.next[index] == null) {
                temp.next[index] = new Node();
                temp.next[index].sb.append(temp.sb).append((char) (index + 'a'));//
            }
            temp = temp.next[index];
        }
        temp.isWord = true;
        temp.num++;
        Node temp2 = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            temp2.num++;
            temp2 = temp2.next[index];
        }
    }

    public boolean contains(char word[]) {
        Node temp = root;
        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if (index < 0 || index > 25)
                return false;
            if (temp.next[index] == null)
                return false;
            else if ((i == word.length - 1) && (temp.next[index].isWord == false))
                return false;
            temp = temp.next[index];
        }
        return true;
    }

    public void remove(char word[]) {
        Node temp = root;
        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if (temp.next[index] == null)
                System.out.println("The string is not in the dictionary and cannot be deleted");
            temp = temp.next[index];
        }
        if (temp.isWord == false)
            System.out.println("The string is not in the dictionary and cannot be deleted");
        else {
            temp.isWord = false;
            temp.num--;
            Node temp2 = root;
            for (int i = 0; i < word.length; i++) {
                int index = word[i] - 'a';
                temp2.num--;
                temp2 = temp2.next[index];
            }
        }
    }

    public void load(String dictionary) {
        String[] str = dictionary.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            this.add(str[i]);
        }
    }

    public boolean containsPrefix(char word[]) {
        Node temp = root;
        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if (temp.next[index] == null)
                return false;
            else
                temp = temp.next[index];
        }
        if (temp.num == 0)
            return false;
        else
            return true;
    }

    public void print(Node node) {
        if (node.isWord == true)
            System.out.println(node.sb);
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                print(node.next[i]);
            }
        }
    }

    public void print() {
        root.print();
    }

    public void printPrefix(char word[]) {
        Node temp = root;
        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if (temp.next[index] == null) {
                System.out.println("There are no words with this prefix in the dictionary");
                return;
            } else
                temp = temp.next[index];
        }
        temp.print();
    }

    public static void main(String[] args) throws FileNotFoundException {
        TrieTree tt1 = new TrieTree();
        Scanner sc = new Scanner(new FileReader("testAdd.txt"));
        /*while(sc.hasNext()){
            tt1.add(sc.next());
        }

        sc=new Scanner(new FileReader("testContains.txt"));
        while(sc.hasNext()){
            String s=sc.next();
            if(tt1.contains(s.toCharArray()))
                System.out.println(s);
        }

        sc=new Scanner(new FileReader("testTriePrefix.txt"));
        while(sc.hasNext()){
            String s=sc.next();
            if(tt1.containsPrefix(s.toCharArray()))
                tt1.printPrefix(s.toCharArray());
        }

        sc=new Scanner(new FileReader("testRemove.txt"));
        while(sc.hasNext()){
            String s=sc.next();
            tt1.remove(s.toCharArray());
        }*/
        //test
        TrieTree tt2 = new TrieTree();
        sc = new Scanner(new FileReader("EE593\\dict.txt"));
        while (sc.hasNext()) {
            tt2.add(sc.next());
        }
        sc = new Scanner(new FileReader("EE593\\prideandprejudice.txt"));
        int count = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            if (!tt2.contains(s.toCharArray()))
                count++;
        }
        System.out.println(count);
    }
}
