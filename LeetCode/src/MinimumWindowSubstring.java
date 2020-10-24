import java.util.HashMap;

/**
 * @author Donglin Chen
 * @create 2019-12-27-19:45
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (contains(s, t) == false)
            return "";
        int i = 0;
        int j = s.length();
        int mini = 0;
        int minj = s.length();
        String temp1, temp2;
        while (true) {
            temp1 = s.substring(i, j);
            j--;
            temp2 = s.substring(i, j);
            if (!contains(temp2, t)) {
                j++;
                break;
            }
        }
        while (true) {
            temp1 = s.substring(i, j);
            i++;
            temp2 = s.substring(i, j);
            if (!contains(temp2, t)) {
                i--;
                break;
            }
        }
        mini = i;
        minj = j;
        while (true) {
            if (j == s.length())
                break;
            i++;
            j++;
            if (contains(s.substring(i, j), t)) {
                while (true) {
                    temp1 = s.substring(i, j);
                    j--;
                    temp2 = s.substring(i, j);
                    if (!contains(temp2, t)) {
                        j++;
                        break;
                    }
                }
                while (true) {
                    temp1 = s.substring(i, j);
                    i++;
                    temp2 = s.substring(i, j);
                    if (!contains(temp2, t)) {
                        i--;
                        break;
                    }
                    mini = i;
                    minj = j;
                }
                mini = i;
                minj = j;
            }
        }
        return s.substring(mini, minj);
    }

    public static boolean contains(String s, String t) {
//        for (int i = 0; i < t.length(); i++) {
//            if (!s.contains(t.charAt(i) + ""))
//                return false;
//        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                int temp=hm.get(s.charAt(i));
                hm.put(s.charAt(i), temp+1);
            }
            else
                hm.put(s.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(hm.containsKey(t.charAt(i))){
                if(hm.get(t.charAt(i))>=1){
                    int temp=hm.get(t.charAt(i));
                    hm.put(t.charAt(i), temp-1);
                }
                else
                    return false;
            }
            else{
                return false;
            }
        }
            return true;
        }
        //public static String indexPin(String str,int i,int j)

        public static void main (String[]args){
//            String s = MinimumWindowSubstring.minWindow(a, b);
//            //System.out.println(MinimumWindowSubstring.contains("bba","aba"));
//            System.out.println(s);
        }
    }
