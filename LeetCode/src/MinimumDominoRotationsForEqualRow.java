import java.util.HashMap;

/**
 * @author Donglin Chen
 * @create 2019-12-30-23:14
 */
public class MinimumDominoRotationsForEqualRow {
    //    public static int minDominoRotations(int[] A, int[] B) {
//        int min=Integer.MAX_VALUE,temp=0;
//        for(int k=1;k<=6;k++){
//            for(int i=0;i<A.length;i++){
//                if(A[i]!=k&&B[i]==k)
//                    temp++;
//                else if(A[i]!=k&&B[i]!=k){
//                    temp=-1;
//                    break;
//                }
//            }
//            if(temp>=0)
//                min=Math.min(min,temp);
//            temp=0;
//            for(int i=0;i<A.length;i++){
//                if(A[i]==k&&B[i]!=k)
//                    temp++;
//                else if(A[i]!=k&&B[i]!=k) {
//                    temp=-1;
//                    break;
//                }
//            }
//            if(temp>=0)
//                min=Math.min(min,temp);
//            temp=0;
//        }
//        if(min==Integer.MAX_VALUE)
//            return -1;
//        return min;
//    }
    public static int minDominoRotations(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int temp;
        int min = Integer.MAX_VALUE;
        int max = 0, maxi = 0;
        hm.put(1, 0);
        hm.put(2, 0);
        hm.put(3, 0);
        hm.put(4, 0);
        hm.put(5, 0);
        hm.put(6, 0);
        for (int i = 0; i < A.length; i++) {
            temp = hm.get(A[i]);
            hm.put(A[i], temp + 1);
            temp = hm.get(B[i]);
            hm.put(B[i], temp + 1);
        }
        for (int i = 1; i <= 6; i++) {
            if (hm.get(i) > max) {
                maxi = i;
                max = hm.get(i);
            }
        }
        temp = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != maxi && B[i] == maxi)
                temp++;
            else if (A[i] != maxi && B[i] != maxi) {
                temp = -1;
                break;
            }
        }
        if (temp >= 0)
            min = Math.min(min, temp);
        temp = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxi && B[i] != maxi)
                temp++;
            else if (A[i] != maxi && B[i] != maxi) {
                temp = -1;
                break;
            }
        }
        if (temp >= 0)
            min = Math.min(min, temp);
        temp = 0;
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }

        public static void main (String[]args){
            int[] a = {3,5,1,2,3};
            int[] b = {3,6,3,3,4};
            //int c = minDominoRotations(a, b);
            System.out.println(minDominoRotations(a, b));
        }
    }
