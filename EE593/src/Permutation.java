import java.util.Stack;

public class Permutation {

    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        int shu[] = {1, 2, 3, 4,5};
        f(shu, 3, 0);
    }

    /**
     * @param shu  待选择的数组
     * @param targ 要选择多少个次
     * @param cur  当前选择的是第几次
     */
    private static void f(int[] shu, int targ, int cur) {
        // TODO Auto-generated method stub
        if (cur == targ) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < shu.length; i++) {
            if (!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, cur + 1);
                stack.pop();
            }

        }
    }
}


