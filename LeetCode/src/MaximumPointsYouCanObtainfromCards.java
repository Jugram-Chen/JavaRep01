import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-30 20:00
 */
public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int min=Integer.MIN_VALUE;
        ArrayList<Integer> preSum=new ArrayList<>();
        preSum.add(0);
        for(int i=0;i<cardPoints.length;i++)
            preSum.add(preSum.get(i)+cardPoints[i]);
        int size=cardPoints.length;
        for(int i=0;i<=k;i++){
            int temp=preSum.get(i+size-k)-preSum.get(i);
            min=Math.min(temp,min);
        }
        return preSum.get(size)-min;
    }
}
