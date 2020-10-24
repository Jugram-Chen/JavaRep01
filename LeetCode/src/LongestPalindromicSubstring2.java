import java.util.ArrayList;

/**
 * @author Donglin Chen
 * @create 2019-12-19-19:55
 */
public class LongestPalindromicSubstring2 {
    public static ArrayList longestPalindrome(String s) {
        char[] c = s.toCharArray();
        ArrayList<String> al = new ArrayList<>();
        if(c.length==1) {
            al.add(s);
            return al;
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < c.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if(c[i]==c[i+1]){
                sb.append(c[i]);
                for(k=i+1;k<c.length;k++){
                    if(c[k]==c[i])
                        sb.append(c[i]);
                    else
                        break;
                }
                j=i-1;

            } else {
                j = i - 1;
                k = i + 1;
                sb.append(c[i]);
            }
            while (true) {
                if ((j <= -1) || (k >= c.length))
                    break;
                else if (c[j] == c[k]) {
                    sb.append(c[k]);
                    sb.insert(0, c[j]);
                    j--;
                    k++;
                } else if (c[j] != c[k])
                    break;
            }
            al.add(sb.toString());
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al = longestPalindrome("cdd");
        int max = 0;
        String maxString = new String();
        for (String str : al) {
            if (str.length() > max) {
                max = str.length();
                maxString = str;
            }
        }
        System.out.println(maxString + "  " + max);
        //System.out.println(al);
    }
}
