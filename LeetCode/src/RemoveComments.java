import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jugram Chen
 * @create 2020-08-13 15:38
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        if (source == null || source.length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<String> result = new ArrayList<>(source.length);
        boolean in = false;
        // init a huge char array to reuse it.
        char[] can = new char[20000];
        int canIndex = -1;

        for (String s : source) {
            char[] cs = s.toCharArray();

            for (int i = 0; i < cs.length; i++) {
                if (in) {
                    if (cs[i] == '*' && i + 1 < cs.length && cs[i + 1] == '/') {
                        in = false;
                        // skip the /
                        i++;
                    }
                } else {
                    if (cs[i] == '/' && i + 1 < cs.length && cs[i + 1] == '/') {
                        // found "//" and ignore the rest of the string
                        break;
                    } else if (cs[i] == '/' && i + 1 < cs.length && cs[i + 1] == '*') {
                        in = true;
                        // skip the *
                        i++;
                    } else {
                        can[++canIndex] = cs[i];
                    }
                }
            }

            if (!in && canIndex >= 0) {
                result.add(String.valueOf(can, 0, canIndex + 1));
                canIndex = -1;
            }
        }

        return result;
    }
//    public static List<String> removeComments(String[] source) {
//        List<String> result = new ArrayList<>();
//        int i = 0;
//        loopA:
//        while (i < source.length) {
//            String tempStr = source[i];
//            if ((tempStr.indexOf("/*") != -1 && tempStr.indexOf("//") == -1)//只有/*
//                    || (tempStr.indexOf("/*") != -1 && tempStr.indexOf("/*") < tempStr.indexOf("//"))) {// /*在先
//                StringBuilder sb = new StringBuilder();
//                sb.append(tempStr.substring(0, tempStr.indexOf("/*")));
//                boolean flag = false;
//                int pos = 0;
//                for (int k = tempStr.indexOf("/*") + 2; k < tempStr.length() - 1; k++) {
//                    if (tempStr.charAt(k) == '*' && tempStr.charAt(k + 1) == '/') {
//                        flag = true;
//                        pos = k;
//                        break;
//                    }
//                }
//                if (flag) {
//                    for(int k= pos+2;k<tempStr.length()-1;k++){
//                        if(tempStr.charAt(k)=='/'&&tempStr.charAt(k+1)=='/'){
//                            sb.append(tempStr.substring(pos + 2,k));
//                            if (!sb.toString().equals(""))
//                                result.add(sb.toString());
//                            i++;
//                            continue loopA;
//                        }
//                    }
//                    sb.append(tempStr.substring(pos + 2));
//                    if (!sb.toString().equals(""))
//                        result.add(sb.toString());
//                    i++;
//                    continue;
//                } else {
//                    i++;
//                    while (i < source.length) {
//                        if (source[i].indexOf("*/") == -1) {
//                            i++;
//                        } else {
//                            for (int k = source[i].indexOf("*/") + 2; k < source[i].length() - 1; k++) {
//                                if (source[i].charAt(k) == '/' && source[i].charAt(k + 1) == '/') {
//                                    sb.append(source[i].substring(source[i].indexOf("*/") + 2, k));
//                                    if (!sb.toString().equals(""))
//                                        result.add(sb.toString());
//                                    i++;
//                                    continue loopA;
//                                }
//                            }
//                            sb.append(source[i].substring(source[i].indexOf("*/") + 2));
//                            if (!sb.toString().equals(""))
//                                result.add(sb.toString());
//                            i++;
//                            continue loopA;
//                        }
//                    }
//                }
//            } else if ((tempStr.indexOf("//") != -1 && tempStr.indexOf("/*") == -1)//只有//
//                    || (tempStr.indexOf("//") != -1 && tempStr.indexOf("//") < tempStr.indexOf("/*"))) {// //在先
//                if (!tempStr.substring(0, tempStr.indexOf("//")).equals(""))
//                    result.add(tempStr.substring(0, tempStr.indexOf("//")));
//                i++;
//            } else {
//                result.add(tempStr);
//                i++;
//            }
//        }
//        return result;
//    }

    /*aa//aa*/
    public static void main(String[] args) {
//        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        String[] source = {"/*/dadb/*/aec*////*//*ee*//*//b*////*badbda//*bbacdbbd*//ceb//*cdd//**//de*////*",};
//        System.out.println(removeComments(source));
    }
}
