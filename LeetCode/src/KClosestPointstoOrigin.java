import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KClosestPointstoOrigin {
    public static int dist(int[] i){
        return i[0]*i[0]+i[1]*i[1];
    }
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if(dist(o1)>dist(o2))//从小到大
//                    return 1;
//                else
//                    return -1;
                return Integer.compare(dist(o1),dist(o2));//从小到大
            }
        });
        int[][] result=new int[K][2];
        for(int i=0;i<K;i++){
            result[i][0]=points[i][0];
            result[i][1]=points[i][1];
        }
        return result;
//        return Arrays.toString(points);
    }
}
