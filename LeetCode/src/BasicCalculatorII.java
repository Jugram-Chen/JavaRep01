import javax.xml.stream.events.Characters;
import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {
        s=s.replace(" ","");
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(true){
            if(Character.isDigit(s.charAt(i))){
                String str="";
                while((i)<s.length()&&Character.isDigit(s.charAt(i))){
                    str=str+s.charAt(i);
                    i++;
                }
                st.push(Integer.parseInt(String.valueOf(str)));
                if(i>=s.length()-1)
                    break;
            }
            else if(s.charAt(i)=='*'){
                int temp1=st.pop();
                String str="";
                i++;
                while((i)<s.length()&&Character.isDigit(s.charAt(i))){
                    str=str+s.charAt(i);
                    i++;
                }
                int temp2=Integer.parseInt(String.valueOf(str));
                int temp3=temp1*temp2;
                st.push(temp3);
                if(i>=s.length()-1)
                    break;
            }
            else if(s.charAt(i)=='/'){
                int temp1=st.pop();
                String str="";
                i++;
                while((i)<s.length()&&Character.isDigit(s.charAt(i))){
                    str=str+s.charAt(i);
                    i++;
                }
                int temp2=Integer.parseInt(String.valueOf(str));
                int temp3=temp1/temp2;
                st.push(temp3);
                if(i>=s.length()-1)
                    break;
            }
            else if(s.charAt(i)=='-'){
                String str="";
                i++;
                while((i)<s.length()&&Character.isDigit(s.charAt(i))){
                    str=str+s.charAt(i);
                    i++;
                }
                st.push(-1*Integer.parseInt(String.valueOf(str)));
                if(i>=s.length()-1)
                    break;
            }
            else{
                i++;
            }

        }
        int result=0;
        for(Integer i2:st)
            result=result+i2;
        return  result;
    }

    public static void main(String[] args) {
        String s="2020";
        System.out.println(calculate(s));
    }
}
