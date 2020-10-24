/**
 * @author Donglin Chen
 * @create 2020-01-10-20:20
 */
public class DecodeWays {
    int way=0;
    public int numDecodings(String s) {
        count(s,0);
        return way;
    }
    public boolean fit(String s,int index){
        if(s.charAt(index)=='0'||s.charAt(index)=='1')
            return true;
        if(s.charAt(index)=='2'&&s.charAt(index+1)>=48&&s.charAt(index+1)<=54)
            return true;
        return false;
    }
    public void count(String s,int index){
        if(index==s.length()){
            way++;
            return;
        }
        if(s.charAt(index)=='0'){
            return;
        }
        if(s.charAt(index)!='0'){
            count(s,index+1);
        }

        if(index!=(s.length()-1)){
            if(fit(s,index))
                count(s,index+2);
        }
    }

    public static void main(String[] args) {
        String s = "00";
        System.out.println(new DecodeWays().numDecodings(s));
    }
}
