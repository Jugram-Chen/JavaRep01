import java.util.ArrayList;

/**
 * @author Donglin Chen
 * @create 2020-01-26-21:42
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length()==0||s.length()==1||s==null)
            return true;
        ArrayList<Character> al=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=48&&s.charAt(i)<=57)||
               (s.charAt(i)>=65&&s.charAt(i)<=90)||
               (s.charAt(i)>=97&&s.charAt(i)<=122)){
                al.add(Character.toLowerCase(s.charAt(i)));
            }

        }
        int i=0;
        int j=al.size()-1;
        while(i<=j){
            if(al.get(i)!=al.get(j))
                return false;
            i++;
            j--;
        }
        System.out.println(al);
        return true;
    }

    public static void main(String[] args) {
//        isPalindrome("a0*q66-k");
        System.out.println(isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
    }
}
