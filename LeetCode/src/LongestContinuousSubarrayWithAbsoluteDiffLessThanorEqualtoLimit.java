/**
 * @author Jugram Chen
 * @create 2020-08-12 11:50
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static int longestSubarray(int[] nums, int limit) {
        int maxp = 0, minp = 0;
        int leftp = 0, rightp = 0;
        int l = 1;
        rightp++;
        while (rightp < nums.length && leftp < nums.length) {
            if (nums[rightp] - nums[minp] > limit) {
                maxp = rightp;
                leftp = rightp - 1;
                minp = rightp;
                while (nums[rightp] - nums[leftp] <= limit) {
                    if (nums[leftp] <= nums[minp])
                        minp = leftp;
                    leftp--;
                }
                leftp++;
                l = Math.max(l, rightp - leftp + 1);
                rightp++;
            } else if (nums[maxp] - nums[rightp] > limit) {
                minp = rightp;
                leftp = rightp - 1;
                maxp = rightp;
                while (nums[leftp] - nums[rightp] <= limit) {
                    if (nums[leftp] >= nums[maxp])
                        maxp = leftp;
                    leftp--;
                }
                leftp++;
                l = Math.max(l, rightp - leftp + 1);
                rightp++;
            } else {
                if (nums[rightp] > nums[maxp])
                    maxp = rightp;
                else if (nums[rightp] < nums[minp])
                    minp = rightp;
                l = Math.max(l, rightp - leftp + 1);
                rightp++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        System.out.println(longestSubarray(nums, 4));
    }
}
