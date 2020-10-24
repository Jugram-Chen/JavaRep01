import java.util.HashMap;

/**
 * @author Jugram Chen
 * @create 2020-08-11 10:54
 */
public class HitCounter {
    HashMap<Integer,Integer> hm;

    /** Initialize your data structure here. */
    public HitCounter() {
        hm=new HashMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!hm.containsKey(timestamp))
            hm.put(timestamp,1);
        else{
            int temp=hm.get(timestamp);
            hm.put(timestamp,temp+1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum=0;
        for(int i=timestamp-299;i<=timestamp;i++){
            if(hm.containsKey(i))
                sum=sum+hm.get(i);
        }
        return sum;
    }
    class Node{

    }
}
