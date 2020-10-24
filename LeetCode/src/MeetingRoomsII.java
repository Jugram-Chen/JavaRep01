import java.util.Collections;
import java.util.HashMap;

/**
 * @author Donglin Chen
 * @create 2020-01-02-21:53
 */
public class MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<intervals.length;i++){
            for(int j=intervals[i][0];j<intervals[i][1];j++){
                if(hm.get(j)==null)
                    hm.put(j,1);
                else{
                    int temp=hm.get(j);
                    temp++;
                    hm.put(j,temp);
                }
            }
        }
//        Collection<Integer> col=hm.values();
//        int max=0;
//        for(Integer i:col){
//            max=Math.max(max,i);
//        }
        int max= Collections.max(hm.values());
        return max;
    }
//    public int minMeetingRooms(Interval[] intervals) {
//        int[] starts = new int[intervals.length];
//        int[] ends = new int[intervals.length];
//        for(int i=0; i<intervals.length; i++) {
//            starts[i] = intervals[i].start;
//            ends[i] = intervals[i].end;
//        }
//        Arrays.sort(starts);
//        Arrays.sort(ends);
//        int rooms = 0;
//        int endsItr = 0;
//        for(int i=0; i<starts.length; i++) {
//            if(starts[i]<ends[endsItr])
//                rooms++;
//            else
//                endsItr++;
//        }
//        return rooms;
//    }

    public static void main(String[] args) {
        //int[][] intervals={{0,30},{5,10},{15,20}};
        //int[][] intervals={{2,4},{7,10}};
        int[][] intervals={{3,4}};
        System.out.println(MeetingRoomsII.minMeetingRooms(intervals));
    }
}
