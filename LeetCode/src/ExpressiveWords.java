/**
 * @author Jugram Chen
 * @create 2020-08-09 13:14
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String str : words) {
            if (check(S, str))
                count++;
        }
        return count;
    }

    public static boolean check(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int i = 0, j = 0;
//        if(s1.charAt(0)==s2.charAt(0))
//            return false;
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j))
                return false;
            else {
                int temp0 = 1;
                int temp1 = 1;
                while (i + 1 < m && s1.charAt(i + 1) == s1.charAt(i)) {
                    i++;
                    temp0++;
                }
                while (j + 1 < n && s2.charAt(j + 1) == s2.charAt(j)) {
                    j++;
                    temp1++;
                }
                if (temp0 == temp1 || (temp0 >= 3 && temp0 >= temp1)) {
                    i++;
                    j++;
                } else
                    return false;
            }
        }
        if (i == m && j == n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s1 = "dddiiiinnssssssoooo";
//        String s2="helo";
//        String s1="heeellooo";
        String s2 = "dinsoo";
        System.out.println(check(s1, s2));
    }
}
