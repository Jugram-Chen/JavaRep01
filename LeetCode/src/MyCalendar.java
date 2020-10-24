import javafx.util.Pair;

import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-23 12:20
 */
public class MyCalendar {
    //    HashSet<Integer> hs;
//    public MyCalendar() {
//        hs=new HashSet<>();
//    }
//
//    public boolean book(int start, int end) {
//        for(int i=start;i<end;i++){
//            if(hs.contains(i))
//                return false;
//        }
//        for(int i=start;i<end;i++){
//            hs.add(i);
//        }
//        return true;
//    }
    ArrayList<Pair<Integer, Integer>> al;

    public MyCalendar() {
        al = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Pair<Integer, Integer> p : al) {
            if (start >= p.getKey() && start < p.getValue())
                return false;
            if (end > p.getKey() && end <= p.getValue())
                return false;
            if (start <= p.getKey() && end >= p.getValue())
                return false;
        }
        al.add(new Pair<Integer, Integer>(start, end));
        return true;
    }
}
