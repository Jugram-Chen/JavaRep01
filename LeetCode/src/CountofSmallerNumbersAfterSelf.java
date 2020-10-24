import java.util.ArrayList;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-06 15:54
 */
public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            int temp=nums[i];
            for(int j=i+1;j<nums.length;i++){
                if(nums[j]<temp)
                    count++;
            }
            al.add(count);
        }
        return al;
    }
}
