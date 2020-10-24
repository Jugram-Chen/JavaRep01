import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jugram Chen
 * @create 2020-08-13 18:25
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            if(!hm.containsKey(i))
                hm.put(i,1);
            else{
                int temp=hm.get(i);
                hm.put(i,temp+1);
            }
        }
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(hm.get(e.getKey())>nums.length/3)
                al.add(e.getKey());
        }
        return al;
    }
}
