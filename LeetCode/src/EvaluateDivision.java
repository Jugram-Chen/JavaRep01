import java.util.*;

/**
 * @author Jugram Chen
 * @create 2020-08-06 15:58
 */
public class EvaluateDivision {//本质上的思路就是将每一个数设为node,并搞清楚两两之间的倍数。求结果的时候使用dfs找关系
    ArrayList<Node> al = new ArrayList<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double qt = values[i];
            Node an, bn;
            an = findNode(a);
            if (an==null)
                an=new Node(a);
            bn = findNode(b);
            if (bn==null)
                an=new Node(a);

        }
        return null;
    }

    public Node findNode(String str) {
        for (Node n : al) {
            if (n.str.equals(str))
                return n;
        }
        return null;
    }

    class Node {
        String str;
        HashMap<String, Double> hm = new HashMap<>();

        public Node(String str) {
            this.str = str;
        }


    }
}
