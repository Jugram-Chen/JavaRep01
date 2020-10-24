import java.util.ArrayList;

/**
 * @author Donglin Chen
 * @create 2019-12-24-19:43
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int maxSize=0;
        for(i=0;i<s.length();i++){
            ArrayList<Character> temp=new ArrayList<>();
            temp.add(s.charAt(i));
            for(j=i+1;j<s.length();j++){
                if(temp.contains(s.charAt(j)))
                    break;
                temp.add(s.charAt(j));
            }
            if(temp.size()>maxSize)
                maxSize = temp.size();
            if(maxSize>s.length()-i)
                break;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}
