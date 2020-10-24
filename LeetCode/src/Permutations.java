import java.util.ArrayList;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-16-18:25
 */
public class Permutations {
    List<List<Integer>> al = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        perm(nums,0,nums.length-1);
        return al;
    }


    public void perm(int[] array, int start, int end) {
        if (start == end) {
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < array.length; i++)
                li.add(array[i]);
            al.add(li);
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                perm(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new int[]{1, 2, 3});
        System.out.println(p.al);
    }
}
