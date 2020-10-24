import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jugram Chen
 * @create 2020-08-03 17:41
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        int[] result = new int[words.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    result[i] = Math.max(result[j] + 1, result[i]);
                }
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public boolean isPredecessor(String str1, String str2) {
        if (str1.length() + 1 != str2.length())
            return false;
        for (int index1 = 0, index2 = 0, diff = 0; index1 < str1.length(); ) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
                index2++;
            } else {
                diff++;
                if (diff > 1) {
                    return false;
                }
                index2++;
            }
        }
        return true;
    }
}
