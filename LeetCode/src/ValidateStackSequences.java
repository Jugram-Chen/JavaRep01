import java.util.Stack;

/**
 * @author Jugram Chen
 * @create 2020-08-07 12:19
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int p0=0,p1=0;
        while(p1!=popped.length){
            int t1=popped[p1];
            if(st.contains(t1)&&st.peek()!=t1)
                return false;
            else if(!st.contains(t1)){
                while(pushed[p0]!=t1){
                    st.push(pushed[p0]);
                    p0++;
                }
                st.push(pushed[p0]);
                p0++;
                st.pop();
                p1++;
            }
            else if(st.peek()==t1){
                st.pop();
                p1++;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5};
        int[] popped={4,3,5,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
}