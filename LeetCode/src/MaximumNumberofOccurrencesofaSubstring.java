import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Jugram Chen
 * @create 2020-08-25 14:44
 */
public class MaximumNumberofOccurrencesofaSubstring {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//        int p1=0,p2=0,count=0;
//        HashMap<Character,Integer> hm=new HashMap<>();
////        hs.add(s.charAt(0));
//        while(true){
//            String temps=s.substring(p1,p2+1);
//            Character tempc=s.charAt(p2);
//            if(!hm.containsKey(tempc)||hm.get(tempc)==0)
//                hm.put(tempc,1);
//            if(temps.length()>=minSize&&temps.length()<=maxSize&&hm.entrySet().size()==maxLetters){
//                count++;
//                p
//            }
//        }
        HashMap<String,Integer> hm=new HashMap<>();
        loopOutside:
        for (int i = 0; i < s.length()-minSize+1; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int k = i; k < i+minSize-1; k++)
                hs.add(s.charAt(k));
            for (int j = i+minSize-1; j < i+maxSize; j++) {
                Character tempc = s.charAt(j);
                String temps = s.substring(i, j + 1);
                hs.add(tempc);
                if (temps.length() >= minSize && temps.length() <= maxSize && hs.size() <= maxLetters) {
                    if(hm.containsKey(temps)){
                        int a=hm.get(temps);
                        hm.put(temps,a+1);
                    }
                    else
                        hm.put(temps,1);
                    continue loopOutside;
                }
                if (hs.size()>maxLetters)
                    continue loopOutside;
            }
        }
        System.out.println(hm);
        int max=0;
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            max=Math.max(max,e.getValue());
        }
        return max;
    }

    public static void main(String[] args) {
        maxFreq("abcde",
                2,
                3,
                3);
    }
}
