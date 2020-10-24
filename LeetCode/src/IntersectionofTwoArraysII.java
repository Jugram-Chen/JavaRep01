import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-11 12:09
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> al1=new LinkedList<>();
        List<Integer> al2=new LinkedList<>();
        for(int i:nums1)
            al1.add(i);
        for(int i:nums2)
            al2.add(i);
        ArrayList<Integer> al=new ArrayList<>();
        for(Integer it:al1){
            if(al2.contains(it)){
                System.out.println(it);
                al.add(it);
                al2.remove(it);
            }

        }
        int[] result=new int[al.size()];
        for(int i=0;i<al.size();i++){
            result[i]=al.get(i);
        }
        return result;
    }
}
