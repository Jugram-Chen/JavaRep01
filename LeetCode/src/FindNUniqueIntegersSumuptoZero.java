import java.util.Arrays;

/**
 * @author Jugram Chen
 * @create 2020-08-14 11:45
 */
public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                result[2 * i] = i + 1;
                result[2 * i + 1] = -i - 1;
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                result[2 * i] = i + 1;
                result[2 * i + 1] = -i - 1;
            }
            result[n - 1] = 0;
        }
        Arrays.toString(result);
        return result;
    }
}
