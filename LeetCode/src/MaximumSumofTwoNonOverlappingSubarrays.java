import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-09 11:37
 */
public class MaximumSumofTwoNonOverlappingSubarrays {
    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(0);
        int result=-1;
        for(int i=0;i<A.length;i++)
            al.add(al.get(i)+A[i]);
        System.out.println(al);
        //假设L在左,M在右
        for(int i=0;i<=A.length-L-M;i++){
            for(int j=i+L;j<=A.length-M;j++){
                int templ=al.get(i+L)-al.get(i);
                int tempm=al.get(j+M)-al.get(j);
                result=Math.max(result,templ+tempm);
            }
        }
        //假设M在左,L在右，
        for(int i=0;i<=A.length-L-M;i++){
            for(int j=i+M;j<=A.length-L;j++){
                int tempm=al.get(i+M)-al.get(i);
                int templ=al.get(j+L)-al.get(j);
                result=Math.max(result,templ+tempm);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={2,1,5,6,0,9,5,0,3,8};
        System.out.println(maxSumTwoNoOverlap(A,4,3));
    }

}
