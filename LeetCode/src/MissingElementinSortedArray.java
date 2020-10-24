/**
 * @author Jugram Chen
 * @create 2020-08-14 12:38
 */
public class MissingElementinSortedArray {
    //    public int missingElement(int[] nums, int k) {
//        int cur=nums[0];
//        int count=0;
//        HashSet<Integer> hs=new HashSet<>();
//        for(int i:nums)
//            hs.add(i);
//        while(true){
//            if(!hs.contains(cur))
//                count++;
//            if(count==k)
//                return cur;
//            cur++;
//        }
//    }
    public int missingElement(int[] nums, int k) {
        int spaceInArr=nums[nums.length-1]-nums[0]+1-nums.length;
        if(k<=spaceInArr){
            int i=0,j=0,cur=nums[0],count=0;
            while(true){
                if(nums[j]==cur)
                    j++;
                else
                    count++;
                if(count==k)
                    return cur;
                cur++;
            }
        }
        else{
            int a=k-spaceInArr;
            return nums[nums.length-1]+2;
        }
    }
}
