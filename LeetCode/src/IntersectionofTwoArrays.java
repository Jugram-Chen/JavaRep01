import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Jugram Chen
 * @create 2020-08-11 11:58
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(int i:nums1)
            hs1.add(i);
        for(int i:nums2)
            hs2.add(i);
        ArrayList<Integer> al=new ArrayList<>();
        for(Integer it:hs1){
            if(hs2.contains(it))
                al.add(it);
        }
        int[] result=new int[al.size()];
        for(int i=0;i<al.size();i++){
            result[i]=al.get(i);
        }
        return result;
    }
}
