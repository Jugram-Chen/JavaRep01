import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-24-15:15
 */
public class WordBreakII {
    List<String> words;
    ArrayList<String> al=new ArrayList<>();
    class Node{
        String str;
        StringBuilder sb;

        public Node(String str, StringBuilder sb) {
            this.str = str;
            this.sb = sb;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        words=wordDict;
        fol(new Node(s,new StringBuilder()));
        return al;
    }
    public void fol(Node n){
        for(int i=0;i<words.size();i++){
            if(n.str.startsWith(words.get(i))){
                if(n.str.length()==words.get(i).length()){
                    StringBuilder tempSb=new StringBuilder(n.sb);
                    tempSb.append(words.get(i));
                    al.add(tempSb.toString());
                    continue;
                }
                String tempStr=n.str.substring(words.get(i).length());
                StringBuilder tempSb=new StringBuilder(n.sb);
                tempSb.append(words.get(i));
                tempSb.append(" ");
                fol(new Node(tempStr,tempSb));
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        WordBreakII wii=new WordBreakII();
        System.out.println(wii.wordBreak(s,words));
    }
}
