/**
 * @author Donglin Chen
 * @create 2019-12-16-16:59
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i;
        int j;
        int[] factor=new int[2];
        for(i=0;i<nums.length-1;i++){
            for(j=i+1;j<nums.length;j++){
                if(target==(nums[i]+nums[j])){
                    factor[0]=i;
                    factor[1]=j;
                    return factor;
                }
            }
        }
        return factor;
    }
}
