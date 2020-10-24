import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2020-01-21-15:13
 */
public class SlidingWindowMaximum {
    //    public static int[] maxSlidingWindow(int[] nums, int k) {//暴力破解
//        if(nums==null||nums.length==0)
//            return new int[0];
//        ArrayList<Integer> al=new ArrayList<>();
//        int max;
//        for(int i=0;i<=nums.length-k;i++){
//            ArrayList<Integer> temp=new ArrayList<>();
//            for(int j=0;j<k;j++) {
//                temp.add(nums[i+j]);
//            }
//            al.add(Collections.max(temp));
//        }
//        int[] ans=new int[al.size()];
//        for(int i=0;i<ans.length;i++)
//            ans[i]=al.get(i);
//        return ans;
//    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        ArrayList<Integer> al = new ArrayList<>();
        int max = nums[0];
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        al.add(max);
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i + k - 1] >= max) {
                max = nums[i + k - 1];
                al.add(max);
            } else if (nums[i - 1] < max) {
                al.add(max);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    temp.add(nums[i + j]);
                }
                max=Collections.max(temp);
                al.add(max);
            }
        }
        int[] ans=new int[al.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=al.get(i);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int ans[]=maxSlidingWindow(nums, 3);
        System.out.println(5);
    }
}
