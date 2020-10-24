import java.util.ArrayList;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2019-12-15-21:44
 */
public class WordBreakTest {
    public static boolean wordBreak(String str, List<String> wordDict){
        if(str.equals(""))
            return true;
        else if(!isMatch(str,wordDict))
            return false;
        else {
            for (String s : wordDict) {
                if (str.contains(s)) {
                    int index = str.indexOf(s);
                    str=str.replaceFirst(s,"");
                    return wordBreak(str, wordDict);
                }
            }
        }
        return false;
    }

    public static boolean isMatch(String str, List<String> wordDict){
        for(String s:wordDict){
            if(str.contains(s))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str="catsandog";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("catsan");
        wordDict.add("dog");
//        String ss1="catsandog";
//        String ss2="san";
//        System.out.println(ss1.replaceFirst(ss2,""));
//        System.out.println(ss1.substring(6,9));
        System.out.println(wordBreak(str,wordDict));
    }
}
