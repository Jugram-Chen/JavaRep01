import java.util.*;

public class TopKFrequentWords {
    class Node {
        String word;
        Integer freq;

        public Node(String str, Integer i) {
            word = str;
            freq = i;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<Node> al = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            al.add(new Node(entry.getKey(), entry.getValue()));
        }
        al.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.freq > o2.freq)
                    return 1;
                else if (o1.freq < o2.freq)
                    return -1;
                else {
                    return -1 * o1.word.compareTo(o2.word);
                }
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(al.get(i).word);
        return result;

    }
}
