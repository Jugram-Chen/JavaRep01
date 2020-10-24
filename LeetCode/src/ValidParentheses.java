import java.util.Stack;

/**
 * @author Donglin Chen
 * @create 2019-12-22-15:45
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length()%2==1)
            return false;
        Stack<Character> stack=new Stack<>();
//        char [] c = s.toCharArray();
//        Character[] c = ArrayUtils.toObject(s.toCharArray(););
//        Character[] c=Array
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)=='(')||(s.charAt(i)=='{')||(s.charAt(i)=='['))
                stack.push(s.charAt(i));
            else{
                if(stack.empty())
                    return false;
                if(s.charAt(i)==')'){
                    if(stack.peek()=='('){
                        stack.pop();
                        continue;
                    }
                    else
                        return false;
                }
                else if(s.charAt(i)==']'){
                    if(stack.peek()=='['){
                        stack.pop();
                        continue;
                    }
                    else
                        return false;
                }
                else if(s.charAt(i)=='}'){
                    if(stack.peek()=='{'){
                        stack.pop();
                        continue;
                    }
                    else
                        return false;
                }

            }
        }
        if(stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s="){";
        System.out.println(ValidParentheses.isValid(s));
    }
}
