import java.util.Stack;

/**
 * @author Donglin Chen
 * @create 2020-01-11-21:12
 */
public class PermutationAndCombination {
    public static Stack<Integer> stack = new Stack<Integer>();

    public static void permutation(int[] shu, int targ, int cur) {
        if (cur == targ) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < shu.length; i++) {
            if (!stack.contains(shu[i])) {
                stack.add(shu[i]);
                permutation(shu, targ, cur + 1);
                stack.pop();
            }

        }
    }

    private static void combination(int[] shu, int targ, int has, int cur) {
        if (has == targ) {
            System.out.println(stack);
            return;
        }

        for (int i = cur; i < shu.length; i++) {
            if (!stack.contains(shu[i])) {
                stack.add(shu[i]);
                combination(shu, targ, has + 1, i);
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        int shu[] = {1, 2, 3,4};
        combination(shu, 2, 0,0);
    }
}
