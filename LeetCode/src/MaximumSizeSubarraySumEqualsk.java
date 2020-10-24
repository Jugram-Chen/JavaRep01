import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-10 14:46
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int ms=0;
        ArrayList<Integer> presum = new ArrayList<>();
        presum.add(0);
        for (int i = 0; i < nums.length; i++)
            presum.add(presum.get(i)+nums[i]);
        System.out.println(presum);
        for (int i = presum.size()-1; i>=0 ;i--){
            for(int j=0;j<i;j++){
                if(presum.get(i)-presum.get(j)==k){
                    ms=Math.max(ms,i-j);
                    break;
                }
            }
        }
        return ms;
    }
}
