import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Donglin Chen
 * @create 2020-01-14-19:08
 */
public class LetterCombinationsofaPhoneNumber {
    Map<String, String> dict= new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    StringBuilder sb=new StringBuilder();
    List<String> res = new ArrayList<String>();

    public void backtrack(String digits,int index) {
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }

        char ch=digits.charAt(index);
        String values=dict.get(ch);
        for(char c:values.toCharArray()){
            sb.append(c);
            backtrack(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0|| digits==null)
            return res;
        backtrack(digits,0);
        return res;
    }

    public static void main(String[] args) {
        String digits="324";
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(digits));
    }
}
