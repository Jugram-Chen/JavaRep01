import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2020-01-17-20:28
 */
public class MedianFinder {
    ArrayList<Integer> al;


    /** initialize your data structure here. */
    public MedianFinder() {
        al=new ArrayList<>();
    }

    public void addNum(int num) {
        al.add(num);
        Collections.sort(al);
    }

    public double findMedian() {
        if(al.size()%2==0)
            return (al.get(al.size()/2-1)+al.get(al.size()/2))/2.0;
        else
            return al.get(al.size()/2);
    }

}
