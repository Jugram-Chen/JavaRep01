/**
 * @author Donglin Chen
 * @create 2020-01-18-15:37
 */
public class RegularExpressionMatching {
//    public static boolean isMatch(String s, String p) {
//        Pattern pat=Pattern.compile(p);
//        Matcher m=pat.matcher(s);//sb是一个String类，同时也是正则表达式p试图去匹配的内容
//        if(m.find()==true){
//            return m.group().equals(s);
//        }
//        return false;
//    }
public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean first_match = (!text.isEmpty() &&
            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        return (isMatch(text, pattern.substring(2)) ||
                (first_match && isMatch(text.substring(1), pattern)));
    } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}

    public static void main(String[] args) {
        //System.out.println(isMatch("aab","c*a*b"));
    }

}
