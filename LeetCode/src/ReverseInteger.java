/**
 * @author Donglin Chen
 * @create 2020-01-16-17:53
 */
public class ReverseInteger {
    //    public static int reverse(int x) {
////        long w=x;
////        if(w==0)
////            return 0;
////        boolean positive;
////        if(w>0)
////            positive=true;
////        else{
////            positive=false;
////            w=w*(-1);
////        }
////        StringBuilder sb=new StringBuilder();
////        while(w!=0){
////            sb.append(w%10);
////            w=w/10;
////        }
////        long z=Long.parseLong(sb.toString());
////        if(z>2147483647||z<-2147483648)
////            return 0;
////        int y=Integer.parseInt(sb.toString());
////        if(positive==true)
////            return y;
////        else
////            return y*-1;
////
////    }
    public static int reverse(int x) {
        int posi = 1;
        long y=x;
        if (y < 0) {
            y = y * -1;
            posi = -1;
        }
        String s = Long.toString(y);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        Long l = Long.parseLong(sb.toString());
//        System.out.println(l);
        if (l > 2147483647 || l < -2147483648)
            return 0;
        return posi * Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
