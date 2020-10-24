import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Donglin Chen
 * @create 2020-01-18-16:22
 */
public class CriticalConnectionsinaNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int q = 0; q < connections.size(); q++) {
            List<Integer> temp = connections.get(q);
            connections.remove(temp);
            int[][] net = new int[n][n];
            for (List<Integer> li : connections) {
                net[li.get(0)][li.get(1)] = 1;
                net[li.get(1)][li.get(0)] = 1;
            }
            int[] vertex = new int[n];
            for (int i = 0; i < n; i++)
                vertex[i] = i;
            boolean[] isVisited = DFS(vertex, net);
            for (int i = 0; i < isVisited.length; i++) {
                if (isVisited[i] == false) {
                    ans.add(temp);
                    break;
                }
            }
            connections.add(q, temp);
        }
        return ans;
    }

    public boolean[] DFS(int[] vertex, int[][] net) {
        boolean[] isVisited = new boolean[vertex.length];
        Stack<Integer> s = new Stack<>();
        s.push(vertex[0]);
        isVisited[0] = true;
        while (!s.empty()) {
            int i = s.pop();
            for (int j = 0; j < vertex.length; j++) {
                if (net[i][j] == 1 && isVisited[j] == false) {
                    s.push(vertex[j]);
                    isVisited[j] = true;
                }
            }
        }
        return isVisited;
    }

    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
//        List<Integer> a= Arrays.asList(0,1);
        al.add(Arrays.asList(0, 1));
        al.add(Arrays.asList(1, 2));
        al.add(Arrays.asList(2, 0));
        al.add(Arrays.asList(1, 3));
        CriticalConnectionsinaNetwork cc = new CriticalConnectionsinaNetwork();
        List<List<Integer>> ans = cc.criticalConnections(4, al);
        System.out.println(ans);
    }
}
