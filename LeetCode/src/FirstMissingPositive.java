import java.util.ArrayList;

/**
 * @author Donglin Chen
 * @create 2020-01-13-17:48
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : nums) {
            if (i > 0)
                al.add(i);
        }
        al.sort(Integer::compareTo);
        int i = 1;
        while (true) {
            if (!al.contains(i))
                return i;
            i++;
        }
    }

    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive2(nums));
    }
}
