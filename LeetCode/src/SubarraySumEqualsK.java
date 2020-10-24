import java.util.HashMap;

public class SubarraySumEqualsK {
    //    public int subarraySum(int[] nums, int k) {//用累加数组也可以
//        int count=0;
//        int sum=0;
//        for(int i=0;i<nums.length;i++){
//            sum=0;
//            for(int j=i;j<nums.length;j++) {
//                sum = sum + nums[j];
//                if (sum == k) {
//                    count++;
//                    break;
//                }
//                if (sum > k)
//                    break;
//            }
//        }
//        return count;
//    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int sum = 0;
        hm.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (hm.containsKey(sum - k))
                count = count + hm.get(sum - k);
            if (hm.containsKey(sum))
                hm.put(sum, hm.get(sum) + 1);
            else
                hm.put(sum, 1);
        }
        return count;
    }
}
