/**
 * @author Jugram Chen
 * @create 2020-08-25 14:33
 */
public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        int[] result=new int[nums.length];
        result[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            result[i]=result[i-1]+nums[i];
        return result;
    }
}
