import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jugram Chen
 * @create 2020-08-13 18:03
 */
public class RotateString {
    public static boolean rotateString(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if(A.equals(""))
            return true;
        loopA:
        for(int i=0;i<A.length();i++){
            for(int j=0;j<A.length();j++){
                int k=i+j;
                if(i+j>=A.length())
                    k=i+j-A.length();
                if(A.charAt(j)!=B.charAt(k))
                    continue loopA;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeba"));
    }

}
