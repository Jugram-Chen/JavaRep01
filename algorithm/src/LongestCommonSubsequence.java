import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-11 11:12
 */
public class LongestCommonSubsequence {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> al = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int[][] c = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            c[0][i] = 0;
        }
        int[][] path = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
//                    System.out.println(nums1[i-1]);//这里会输出两次同样的值
                    al.add(nums1[i - 1]);
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    path[i][j] = 1;
                } else {
                    c[i][j] = c[i][j - 1];
                    path[i][j] = -1;
                }
            }
        }
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size() / 2; i++)
            result[i] = al.get(2*i);
        System.out.println(al);
        return result;
//        System.out.println("path:");
//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(path[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        PrintLCS(path, nums1, m, n);
    }

    public static void PrintLCS(int[][] b, int[] nums, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == 0) {
            PrintLCS(b, nums, i - 1, j - 1);
            System.out.println(nums[i - 1]);
        } else if (b[i][j] == 1) {
            PrintLCS(b, nums, i - 1, j);
        } else {
            PrintLCS(b, nums, i, j - 1);
        }
    }
}
