import java.util.Arrays;

/**
 * @author Donglin Chen
 * @create 2020-01-20-21:25
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
