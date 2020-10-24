import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-23 13:13
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        ArrayList<Integer> al = new ArrayList<>(cost.length + 1);
        al.add(0);
        al.add(0);
        for (int i = 2; i <= cost.length; i++) {
            al.add(Math.min(al.get(i - 2) + cost[i - 2], al.get(i - 1) + cost[i - 1]));
        }
        return al.get(cost.length);
    }

    public static void main(String[] args) {
        int[] cost = {0, 0, 1, 0};
        System.out.println(minCostClimbingStairs(cost));
    }
}
