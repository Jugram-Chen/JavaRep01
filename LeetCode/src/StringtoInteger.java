public class StringtoInteger {
    public int myAtoi(String str) {
        str=str.trim();
        if(!((str.charAt(0)<58&&str.charAt(0)>47)||str.charAt(0)==45))
            return 0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)<58&&str.charAt(i)>47)||str.charAt(i)==45)
                sb.append(str.charAt(i));
            else
                break;
        }
        double d=Double.valueOf(sb.toString());
        if(d>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(d<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return Integer.valueOf(sb.toString());
    }
}
