import java.util.ArrayList;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-08-17:06
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null)
            return null;
        else if(matrix.length==0)
            return new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j]=matrix[i][j];
            }
        }
        while(temp.length>=2&&temp[0].length>=2) {
            m=temp.length;
            n=temp[0].length;
            for (int i = 0; i < n; i++)
                ans.add(temp[0][i]);
            for (int i = 1; i < m; i++)
                ans.add(temp[i][n - 1]);
            for (int i = n - 2; i >= 0; i--)
                ans.add(temp[m - 1][i]);
            for (int i = m - 2; i >= 1; i--)
                ans.add(temp[i][0]);
            temp=shrink(temp);
        }
        if(temp.length==0)
            return ans;
        if(temp.length==1){
            for(int i=0;i<temp[0].length;i++)
                ans.add(temp[0][i]);
        }
        else if(temp[0].length==1){
            for(int i=0;i<temp.length;i++)
                ans.add(temp[i][0]);
        }
        return ans;
    }
        public static int[][] shrink(int[][] temp){
            int[][] temp2 = new int[temp.length][temp[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp2[i][j]=temp[i][j];
                }
            }
            temp=new int[temp.length-2][temp[0].length-2];
            for (int i = 1; i < temp2.length-1; i++) {
                for (int j = 1; j < temp2[0].length-1; j++) {
                    temp[i-1][j-1]=temp2[i][j];
                }
            }
            return temp;
        }

    public static void main(String[] args) {
//        int[][] matrix={{1,2,3,4,5},
//                        {5,7,8,9,10},
//                        {11,12,13,14,15},
//                        {16,17,18,19,20},
//                        {21,22,23,24,25}};
//        int[][] matrix={{1,2,3,4,5},
//                        {5,7,8,9,10},
//                        {11,12,13,14,15}};
        int[][] matrix = {{1, 2},{3,4}};
        //int[][] matrix={{1},{3},{5}};
        //int[][] matrix = {{1, 2, 3}};
        System.out.println(spiralOrder(matrix));
//        matrix=shrink(matrix);
        System.out.println();
    }
}
