import java.util.HashSet;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-14 12:15
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    int max = 0;

    public int maxLength(List<String> arr) {
        if (arr == null)
            return 0;
        helper(arr, "", 0);
        return max;
    }

    public void helper(List<String> arr, String path, int n) {
        max = Math.max(max, path.length());
        for (int i = n; i < arr.size(); i++) {
            if (isUnique(path + arr.get(i))) {
                helper(arr, path + arr.get(i), i + 1);
            }
        }
    }

    public boolean isUnique(String path) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < path.length(); i++) {
            if (set.contains(path.charAt(i)))
                return false;
            set.add(path.charAt(i));
        }
        return true;
    }
}
