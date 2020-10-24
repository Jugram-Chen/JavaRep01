import java.util.TreeSet;

/**
 * @author Jugram Chen
 * @create 2020-08-07 14:40
 */
public class KEmptySlots {
    //    public int kEmptySlots(int[] bulbs, int K) {
//        int[] al=new int[bulbs.length];
//        for (int i = 0; i < bulbs.length; i++) {
//            int temp = bulbs[i];
//            al[temp-1]=1;
//            if(i+1>bulbs.length-K)
//                return -1;
//            boolean b = check(al, K);
//            if (b == true)
//                return i + 1;
//        }
//        return -1;
//    }
//
//    public boolean check(int[] al, int k) {
//        loopa:
//        for (int i = 0; i < al.length - 1 - k; i++) {
//            if (al[i] == 1 && al[i+k+1] == 1) {
//                for (int j = i; j <= i + k; j++) {
//                    if (al[j] != 0)
//                        continue loopa;
//                }
//                return true;
//            }
//        }
//        return false;
//    }
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower : flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] bulbs = {1, 3, 2};
        new KEmptySlots().kEmptySlots(bulbs, 1);
    }
}
