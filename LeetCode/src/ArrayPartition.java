import java.util.Arrays;

/**
 * @author Jugram Chen
 * @create 2020-08-26 13:00
 */
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }
}
