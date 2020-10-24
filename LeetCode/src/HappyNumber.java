import java.util.HashSet;
import java.util.Set;

/**
 * @author Donglin Chen
 * @create 2019-12-30-21:09
 */
public class HappyNumber {
//    public static boolean isHappy(int n) {
//        int a,b,c,temp=0;
//        HashSet<Integer> hs=new HashSet<>();
//        while(true){
//            int[] num=transform(n);
//            for(int i=0;i<num.length;i++){
//                temp=temp+num[i]*num[i];
//            }
//            if(temp==1)
//                return true;
//            else if(hs.contains(temp))
//                return false;
//            else{
//                hs.add(temp);
//                n=temp;
//                temp=0;
//            }
//        }
//    }
//    public static int[] transform(Integer n){
//        String str = n.toString();// 转化为字符串
//        int[] num = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            Character ch = str.charAt(i);
//            num[i] = Integer.parseInt(ch.toString());
//        }
//        return num;
//    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
//        int[] num=HappyNumber.transform(157246);
        boolean b=HappyNumber.isHappy(1221);
        System.out.println(b);
    }
}
