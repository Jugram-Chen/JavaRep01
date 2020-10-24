import java.util.LinkedList;

/**
 * @author Jugram Chen
 * @create 2020-08-23 11:47
 */
public class MovingAveragefromDataStream {
    class MovingAverage {
        LinkedList<Integer> ll;
        int size;
        double sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            ll = new LinkedList<Integer>();
            sum = 0;
        }

        public double next(int val) {
            if (ll.size() < size) {
                ll.add(val);
                sum = sum + val;
                return sum / ll.size();
            } else {
                int temp = ll.get(0);
                ll.remove(0);
                ll.add(val);
                sum = sum - temp + val;
                return sum / size;
            }
        }
    }

}
