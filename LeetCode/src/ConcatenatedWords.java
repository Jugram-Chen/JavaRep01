import java.util.*;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Map<String, ArrayList<String>> hm = new HashMap<>();
        for (String str : words) {
            hm.put(str, new ArrayList<String>());
        }
        for (Map.Entry<String, ArrayList<String>> e : hm.entrySet()) {
            for (String str : words) {
                String s = e.getKey();
                if (e.getKey().indexOf(str) != -1 && e.getKey().equals(str) == false)
                    e.getValue().add(str);
            }
        }
//        System.out.println(hm);
        for (Map.Entry<String, ArrayList<String>> e : hm.entrySet()) {
            if (wordBreak(e.getKey(), e.getValue()))
                result.add(e.getKey());
        }
        return result;
    }

    public boolean wordBreak(String str, ArrayList<String> wordDic) {
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDic.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
//        String[] s1 = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
//        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(s1));
//        System.out.println(new ConcatenatedWords().wordBreak("dogcatsdog",new String[]{"cat", "cats", "dog"}));
        System.out.println("".equals(""));
    }
}