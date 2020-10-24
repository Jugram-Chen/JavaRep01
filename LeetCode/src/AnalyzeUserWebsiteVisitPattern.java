import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> al0=new ArrayList<>();
        HashMap<List<String>,Integer> hm=new HashMap<>();
        for(int i=0;i<username.length;i++){
            List<String> alTemp=new ArrayList<>();
            alTemp.add(username[i]);

        }
        return al0;
    }
    public static void main(String[] args) {
        List<String> al1=new ArrayList<>();
        al1.add("a");
        al1.add("b");
        al1.add("c");
        List<String> al2=new ArrayList<>();
        al2.add("a");
        al2.add("b");
        al2.add("c");

        List<List<String>> al3=new ArrayList<>();
        al3.add(al1);
        System.out.println(al3.contains(al2));
    }
}
