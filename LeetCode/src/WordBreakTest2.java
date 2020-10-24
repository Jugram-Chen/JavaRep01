import java.util.*;

/**
 * @author Donglin Chen
 * @create 2019-12-15-22:59
 */
public class WordBreakTest2 {//广度遍历
    public boolean wordBreak(String s, List<String> wordDict){
        Queue<Integer> queue=new LinkedList<>();
        int[] visited=new int[s.length()];
        queue.add(0);
        while(!queue.isEmpty()){
            int start=queue.remove();
            if(visited[start]==0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start]=1;
            }
        }
        return false;
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
