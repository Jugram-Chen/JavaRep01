/**
 * @author Donglin Chen
 * @create 2020-01-10-21:47
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int row=m-1,col=0;
        while(row>=0&&col<n){
            if(matrix[row][col]==target)
                return true;
            if(matrix[row][col]>target)
                row--;
            else
                col++;
        }
        return false;
    }
}
