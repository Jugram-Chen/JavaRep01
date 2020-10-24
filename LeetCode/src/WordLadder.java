import java.util.*;

/**
 * @author Donglin Chen
 * @create 2020-01-17-19:33
 */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        if(hs.contains(beginWord))
            hs.remove(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                char[] temp=q.poll().toCharArray();
                if(endWord.equals(new String(temp)))
                    return level;
                for(int j=0;j<temp.length;j++){
                    char temp2=temp[j];
                    for(char c='a';c<='z';c++){
                        temp[j]=c;
                        String s=new String(temp);
                        if(hs.contains(s)){
                            q.offer(s);
                            hs.remove(s);
                        }
                    }
                    temp[j]=temp2;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList=new ArrayList<>();
        wordList.add("ted");
        wordList.add("tex");
        wordList.add("red");
        wordList.add("tax");
        wordList.add("tad");
        wordList.add("den");
        wordList.add("rex");
        wordList.add("pee");
        System.out.println(ladderLength(beginWord,endWord,wordList));

    }
}
