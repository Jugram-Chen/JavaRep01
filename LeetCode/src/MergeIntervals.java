import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Donglin Chen
 * @create 2019-12-31-16:03
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int fir=0;
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> other=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]==intervals[i][1]) {
                if(!other.contains(intervals[i][1]))
                    other.add(intervals[i][0]);
            }
            for(int j=intervals[i][0];j<=intervals[i][1]-1;j++){
              if(!al.contains(j))
                  al.add(j);
            }
        }
        Collections.sort(al);
        Collections.sort(other);
        ArrayList<Integer[]> ans=new ArrayList<>();
        for(int i=0;i<al.size();i++){
            if(i==al.size()-1){
                Integer[] temp={al.get(fir), al.get(i)};
                ans.add(temp);
            }
            else if(al.get(i+1)-al.get(i)>1) {
                Integer[] temp={al.get(fir), al.get(i)};
                ans.add(temp);
                fir=i+1;
            }
        }
        for(int i=0;i<ans.size();i++){
            ans.get(i)[1]=ans.get(i)[1]+1;
        }
        if(ans.size()==0){
            int[][] answer=new int[other.size()][2];
            for(int i=0;i<other.size();i++){
                answer[i][0]=other.get(i);
                answer[i][1]=other.get(i);
            }
            return answer;
        }


        for(int j=0;j<other.size();j++){
            if(ans.get(0)[0]>other.get(j)) {
                Integer[] temp={other.get(j),other.get(j)};
                ans.add(0,temp);
            }
            else if(ans.get(ans.size()-1)[1]<other.get(j)){
                Integer[] temp={other.get(j),other.get(j)};
                ans.add(temp);
            }
            else {
                for (int i = 0; i < ans.size() - 1; i++) {
                    if ((ans.get(i)[1] < other.get(j)) && (ans.get(i + 1)[0] > other.get(j))) {
                        Integer[] temp = {other.get(j), other.get(j)};
                        ans.add(i + 1, temp);
                        break;
                    }
                }
            }
        }
        int[][] answer=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            answer[i][0]=ans.get(i)[0];
            answer[i][1]=ans.get(i)[1];
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] intervals={{1,1},{3,3},{0,0},{0,0},{1,1}};
        //int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals={{1,4},{0,0}};
        //int[][] intervals={{1,3},{2,4},{5,5},{7,9},{8,8},{10,10}};
        int[][] answer=MergeIntervals.merge(intervals);
//        ArrayList<Integer[]> ans=MergeIntervals.merge(intervals);
        System.out.println(answer);
    }
}
