import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Jugram Chen
 * @create 2020-08-09 13:46
 */
public class MostStonesRemovedwithSameRoworColumn {
    ArrayList<Stone> allStone = new ArrayList<>();
    ArrayList<Boolean> isVisted = new ArrayList<>();
    ArrayList<Island> allIsland = new ArrayList<>();

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            allStone.add(new Stone(stone[0], stone[1]));
            isVisted.add(false);
        }
        while (isVisted.contains(false)) {
            int i;
            Island il0 = new Island();
            for (i = 0; i < isVisted.size(); i++) {
                if (isVisted.get(i) == false) {
                    isVisted.set(i, true);
                    Stone s0 = allStone.get(i);
                    il0.num = 1;
                    il0.xRay.add(s0.x);
                    il0.yRay.add(s0.y);
                    dfs(s0, il0);
                    allIsland.add(il0);
                    System.out.println(il0);
                }
            }
        }
        return stones.length-allIsland.size();
    }

    public void dfs(Stone s, Island il) {
        for (int i = 0; i < allStone.size(); i++) {
            Stone s1 = allStone.get(i);
            if (!isVisted.get(i) && (il.xRay.contains(s1.x) || il.yRay.contains(s1.y))) {
                isVisted.set(i, true);
                il.num++;
                il.xRay.add(s1.x);
                il.yRay.add(s1.y);
                dfs(s1, il);
            }
        }
    }

    class Island {
        int num = 0;
        HashSet<Integer> xRay = new HashSet<>();
        HashSet<Integer> yRay = new HashSet<>();

        @Override
        public String toString() {
            return "Island{" +
                    "num=" + num +
                    ", xRay=" + xRay +
                    ", yRay=" + yRay +
                    '}';
        }
    }

    class Stone {
        int x;
        int y;

        public Stone(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
