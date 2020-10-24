import java.util.*;

/**
 * @author Donglin Chen
 * @create 2020-01-27-20:40
 */
public class RandomizedSet {
    HashMap<Integer,Boolean> hm;
    public RandomizedSet() {
        hm=new HashMap<>();
    }
    public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        hm.put(val,true);
        return true;
    }
    public boolean remove(int val) {
        if(hm.containsKey(val)) {
            hm.remove(val);
            return true;
        }
        return false;
    }
    public int getRandom() {
        List<Integer> al= new ArrayList<>(hm.keySet());
        return al.get((int)(Math.random()*al.size()));
    }


}
