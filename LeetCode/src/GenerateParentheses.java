import java.util.ArrayList;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-04-20:38
 */
public class GenerateParentheses {
//    public List<String> generateParenthesis(int n) {
//        ArrayList<String> al = new ArrayList<>();
//        StringBuilder sb=new StringBuilder();
//        for(int i)
//    }

    //    static ArrayList<String> al = new ArrayList<>();
//    public static void fullSort(char[] arr, int start, int end) {
//        // 递归终止条件
//
//        if (start == end) {
//            StringBuilder sb=new StringBuilder();
//            for (char c : arr) {
//                sb.append(c);
//            }
//            if(!al.contains(sb.toString())){
//                System.out.println(sb);
//                al.add(sb.toString());
//            }
//            return;
//        }
//        for (int i = start; i <= end; i++) {
//                swap(arr, i, start);
//                fullSort(arr, start + 1, end);
//                swap(arr, i, start);
//        }
//    }
//
//    public static void swap(char[] arr, int i, int j) {
//        char tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        char[] arr = {'(', '(', ')'};
//        fullSort(arr, 0, arr.length - 1);
        System.out.println();
    }
}
