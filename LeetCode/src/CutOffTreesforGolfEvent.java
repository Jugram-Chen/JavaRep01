import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-12 13:23
 */
public class CutOffTreesforGolfEvent {
    class Solution {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        public int cutOffTree(List<List<Integer>> forest) {
            List<int[]> trees = new ArrayList();
            for (int r = 0; r < forest.size(); ++r) {
                for (int c = 0; c < forest.get(0).size(); ++c) {
                    int v = forest.get(r).get(c);
                    if (v > 1) trees.add(new int[]{v, r, c});
                }
            }

            Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

            int ans = 0, sr = 0, sc = 0;
            for (int[] tree: trees) {
                int d = dist(forest, sr, sc, tree[1], tree[2]);
                if (d < 0) return -1;
                ans += d;
                sr = tree[1]; sc = tree[2];
            }
            return ans;
        }
        public int dist(List f,int sr,int sc,int t1,int t2){
            return 0;
        }
    }
}
