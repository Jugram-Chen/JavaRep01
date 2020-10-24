import java.util.*;

public class AddandSearchWord {
}

//class WordDictionary {
//    List<String> al;
//    public WordDictionary() {
//        al = new ArrayList<>();
//    }
//    public void addWord(String word) {
//        al.add(word);
//    }
//    public boolean search(String word) {
//        if (word.indexOf(".") == -1) {
//            if (al.contains(word))
//                return true;
//            else
//                return false;
//        }
//        ArrayList<String> temp = sameLength(word);
//
//        loop1:
//        for (String s : temp) {
//            for (int i = 0; i < word.length(); i++) {
//                if (word.charAt(i) == '.')
//                    continue;
//                if (word.charAt(i)!=s.charAt(i))
//                    continue loop1;
//            }
//            return true;
//        }
//        return false;
//    }
//    public ArrayList<String> sameLength(String str) {
//        int l = str.length();
//        ArrayList<String> temp2 = new ArrayList<>();
//        for (String s : al) {
//            if (s.length() == l)
//                temp2.add(s);
//        }
//        return temp2;
//    }
//}
class WordDictionary {
    Map<Integer, Set<String>> d;

    /** Initialize your data structure here. */
    public WordDictionary() {
        d = new HashMap();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int m = word.length();
        if (!d.containsKey(m)) {
            d.put(m, new HashSet());
        }
        d.get(m).add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int m = word.length();
        if (d.containsKey(m)) {
            for (String w : d.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) return true;
            }
        }
        return false;
    }
}

