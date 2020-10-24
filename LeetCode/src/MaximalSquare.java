import java.util.ArrayList;
import java.util.Random;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int l=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int temp=maxSquare(matrix,i,j);
                    l=Math.max(l,temp);
                }
            }
        }
        return l*l;
    }
    public int maxSquare(char[][] matrix,int m,int n){
        System.out.println("aaa");
        int l=1;
        int k=1;
        loopA:
        while((m+k)<matrix.length&&(n+k)<matrix[0].length){
            for(int i=m;i<m+k;i++){
                if(matrix[i][n+k]=='0')
                    break loopA;
            }
            for(int j=n;j<m+k;j++){
                if(matrix[m+k][j]=='0')
                    break loopA;
            }
            if(matrix[m+k][n+k]=='0')
                break loopA;
            k++;
            l++;
        }
        return l;
    }
}
//class Solution {
//    ArrayList<Integer> al=new ArrayList<>();
//
//    public Solution(int[] w) {
//        for(int i=0;i<w.length;i++){
//            int temp=w[i];
//            for(int j=0;j<temp;j++)
//                al.add(i);
//        }
//    }
//
//    public int pickIndex() {
//        Random random = new Random();
//        int n = random.nextInt(al.size());
//
//        return al.get(n);
//    }
//}
class Solution {
    ArrayList<Integer> p=new ArrayList<>();

    public Solution(int[] w) {
        p.add(w[0]);
        for(int i=1;i<w.length;i++){
            p.add(w[i]+p.get(i-1));
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int n = random.nextInt(p.get(p.size()-1)+1);
        if(n<=p.get(0))
            return 1;
        else{
            for(int i=1;i<p.size();i++){
                if(n>p.get(i-1)&&n<p.get(i))
                    return i;
            }
        }
        return 0;
    }
}
