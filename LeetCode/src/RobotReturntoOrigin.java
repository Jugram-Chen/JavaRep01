import java.util.ArrayList;

/**
 * @author Jugram Chen
 * @create 2020-08-09 13:11
 */
public class RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        ArrayList<Character> l=new ArrayList<>();
        ArrayList<Character> r=new ArrayList<>();
        ArrayList<Character> u=new ArrayList<>();
        ArrayList<Character> d=new ArrayList<>();
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')
                l.add(moves.charAt(i));
            if(moves.charAt(i)=='R')
                r.add(moves.charAt(i));
            if(moves.charAt(i)=='U')
                u.add(moves.charAt(i));
            if(moves.charAt(i)=='D')
                d.add(moves.charAt(i));
        }
        if(l.size()==r.size()&&u.size()==d.size())
            return true;
        return false;

    }
}
