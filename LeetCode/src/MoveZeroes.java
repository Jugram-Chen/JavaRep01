import java.util.ArrayList;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
//        int[] nums2=new int[nums.length];
        ArrayList<Integer> al=new ArrayList<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count++;
            else
                al.add(nums[i]);
        }
        for(int i=0;i<count;i++){
            al.add(0);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=al.get(i);
        }
    }

}
