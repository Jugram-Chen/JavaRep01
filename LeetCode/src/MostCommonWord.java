import java.util.*;
import java.util.regex.Pattern;

public class MostCommonWord {
    public  String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
//        RegularExpressionMatching reg=new RegularExpressionMatching();
        String[] words = paragraph.split("[^A-Za-z]+");
        //System.out.println(Arrays.toString(words));
        HashMap<String, Integer> hm = new HashMap<>();
        for (String str : words) {
            if (!hm.containsKey(str))
                hm.put(str, 1);
            else {
                int temp = hm.get(str);
                hm.put(str, ++temp);

            }
        }
        List<Node> al = new ArrayList<>();
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            al.add(new Node(e.getKey(), e.getValue()));
        }
        al.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -1 * Integer.compare(o1.freq, o2.freq);
            }
        });
        //System.out.println(al);
        for (Node n : al) {
            List<String> banned2 = Arrays.asList(banned);
            if (!banned2.contains(n.str))
                return n.str;
        }
        return null;
    }

    class Node {
        String str;
        int freq;

        public Node(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static void main(String[] args) {
        String str="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(str,banned));
    }
}

