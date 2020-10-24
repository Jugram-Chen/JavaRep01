import java.util.HashMap;

/**
 * @author Jugram Chen
 * @create 2020-08-08 14:32
 */
public class SnapshotArray {
    //    ArrayList<ArrayList<Integer>> all = new ArrayList<>();
//    ArrayList<Integer> cur = new ArrayList<>();
//
//    public SnapshotArray(int length) {
//        for (int i = 0; i < length; i++)
//            cur.set(i, 0);
//
//    }
//
//    public void set(int index, int val) {
//        cur.set(index, val);
//    }
//
//    public int snap() {
//        ArrayList<Integer> copy=new ArrayList<>();
//        for(int i:cur){
//            copy.add(i);
//        }
//        all.add(copy);
//        return all.size() - 1;
//    }
//
//    public int get(int index, int snap_id) {
//        return all.get(snap_id).get(index);
//    }
    HashMap<String, Integer> mp;
    int snap;

    public SnapshotArray(int length) {
        mp = new HashMap();
        snap = 0;
        for (int i = 0; i < length; i++)
            mp.put(i + "-" + snap, 0);
    }

    public void set(int index, int val) {
        mp.put(index + "-" + snap, val);

    }

    public int snap() {
        snap++;
        return snap - 1;

    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (mp.containsKey(index + "-" + snap_id))
                return mp.get(index + "-" + snap_id);
            else
                snap_id--;

        }
        return 0;
    }
}
