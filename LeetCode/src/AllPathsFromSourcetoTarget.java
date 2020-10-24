import java.util.ArrayList;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-14 13:49
 */
public class AllPathsFromSourcetoTarget {
    List<List<Integer>> ways = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> way = new ArrayList<>();
        dfs(graph, way, 0);
        return ways;
    }

    public void dfs(int[][] graph, List<Integer> way, int node) {
        if (node == graph.length - 1) {
            way.add(node);
            ways.add(way);
            return;
        }
        way.add(node);
        for (int i = 0; i < graph[node].length; i++) {
            int nextNode = graph[node][i];
            if (!way.contains(nextNode)) {
                List<Integer> newWay = clone(way);
                dfs(graph, newWay, nextNode);
            }
        }
    }

    public List<Integer> clone(List<Integer> al) {
        List<Integer> newAl = new ArrayList<>();
        for (int i : al)
            newAl.add(i);
        return newAl;
    }
}
