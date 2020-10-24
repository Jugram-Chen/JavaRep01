import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-09-20:47
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> al=new ArrayList<>();
        loop1:for(int i=0;i<strs.length;i++){
            for(int j=0;j<al.size();j++){
                if(compareArg(al.get(j).get(0),strs[i])) {
                    al.get(j).add(strs[i]);
                    continue loop1;
                }
            }
            ArrayList<String> al2=new ArrayList<String>();
            al2.add(strs[i]);
            al.add(al2);
        }
        return al;
    }
    public static boolean compareArg(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        a = String.valueOf(ac);
        b = String.valueOf(bc);
        return a.equals(b);
    }

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
