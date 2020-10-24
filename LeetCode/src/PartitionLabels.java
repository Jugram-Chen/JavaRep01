import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> hm=new HashMap<>();
        List<Integer> result =new ArrayList<>();
        for(int i=S.length()-1;i>=0;i--){
            if(!hm.containsKey(S.charAt(i)))
                hm.put(S.charAt(i),i);
        }
        int start=0,last=0;
        int max=hm.get(S.charAt(0));
        while(true){
            max=Math.max(max,hm.get(S.charAt(last)));
            if(last==max){
                result.add(last-start+1);
                if(last == S.length() - 1)
                    break;
                start = last + 1;
                last = last + 1;
            }
            else{
                max=Math.max(max,hm.get(S.charAt(last)));
                if(last < S.length() - 1)
                    last++;
            }
        }
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String str="ababcbacadefegdehijhklij";
        String str2="vhaagbqkaq";
        System.out.println(partitionLabels(str2));
    }
}
