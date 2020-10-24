import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2020-01-11-22:13
 */
/*public class CoinChange {
    ArrayList<Integer> al=new ArrayList<>();
    int amt;
    int[] son;
    class Node{
        int num;
        int sum;
        int level;
        Node[] fol;

        public Node(int num, int sum, int level) {
            this.num = num;
            this.sum = sum;
            this.level = level;
        }
    }
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0||coins==null)
            return -1;
        amt=amount;
        son=coins;
        Node zero=new Node(0,0,0);
        combine(zero);
        if(al.size()==0)
            return -1;
        return Collections.min(al);
    }
    public void combine(Node n){
        if(n.sum==amt){
            al.add(n.level);
            return;
        }
        else if(n.sum>amt)
            return;
        else{
            n.fol=new Node[son.length];
            for(int i=0;i<son.length;i++){
                n.fol[i]=new Node(son[i],n.sum+son[i],n.level+1);
                combine(n.fol[i]);
            }

        }
    }*/
public class CoinChange {
    ArrayList<Integer> al = new ArrayList<>();
    double amt;
    double[] son;

    class Node {
        double num;
        double sum;
        int level;
        Node[] fol;

        public Node(double num, double sum, int level) {
            this.num = num;
            this.sum = sum;
            this.level = level;
        }
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null)
            return -1;
        amt = amount;
        Arrays.sort(coins);
        son=new double[coins.length];
        for(int i=0;i<coins.length;i++)
            son[i]=coins[coins.length-1-i];
        Node zero = new Node(0, 0, 0);
        combine(zero);
        if (al.size() == 0)
            return -1;
        return Collections.min(al);
    }

    public void combine(Node n) {
        if(al.size()==1)
            return;
        if (n.sum == amt) {
            al.add(n.level);
            return;
        } else if (n.sum > amt)
            return;
        else {
            n.fol = new Node[son.length];
            for (int i = 0; i < son.length; i++) {
                n.fol[i] = new Node(son[i], n.sum + son[i], n.level + 1);
                combine(n.fol[i]);
            }

        }
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(coins, 6249));
    }
}
