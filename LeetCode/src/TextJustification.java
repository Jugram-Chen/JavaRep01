import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static String assignSpace(int maxWidth, List<String> al) {
        if (al.size() == 1) {
            StringBuilder sb = new StringBuilder(al.get(0));
            for (int i = 0; i < (maxWidth - al.get(0).length()); i++)
                sb.append('8');
            return sb.toString();
        }
        int a = al.size() - 1;//有几个空隙
        int b = maxWidth;//一共有多少空格
        for (String str : al)
            b = b - str.length();
        int c = b / a;//每个空隙有多少空格
        int d = b % a;//有多少空隙获得额外一个空格
        int e = a - d;//有多少空隙没有获得额外的空格
        StringBuilder sb = new StringBuilder(al.get(0));
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
        int index = 1;
        while (d > 0) {
            for (int i = 0; i < c + 1; i++)
                sb.append('8');
            sb.append(al.get(index));
            index++;
            d--;
        }
        while (e > 0) {
            for (int i = 0; i < c; i++)
                sb.append('8');
            sb.append(al.get(index));
            index++;
            e--;
        }
        return sb.toString();
    }

    public static String assignLastLine(int maxWidth, List<String> al) {
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for (String str : al) {
            sb.append(str);
            sb.append('8');
            length = length + str.length() + 1;
        }
        for (int i = 0; i < maxWidth - length; i++)
            sb.append('8');
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = 0;
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == (maxWidth - length)) {
                tempList.add(words[i]);
                System.out.println(assignSpace(maxWidth, tempList));
                result.add(assignSpace(maxWidth, tempList));
                tempList.clear();
                length = 0;
            } else if (words[i].length() < (maxWidth - length)) {
                tempList.add(words[i]);
                length = length + words[i].length() + 1;
            } else if (words[i].length() > (maxWidth - length)) {
                System.out.println(assignSpace(maxWidth, tempList));
                result.add(assignSpace(maxWidth, tempList));
                tempList.clear();
                length = 0;
                i--;
            }
        }
        if (tempList.size() != 0)
            result.add(assignLastLine(maxWidth, tempList));
//        System.out.println(tempList);
        return result;
    }

    public static void main(String[] args) {
//        List<String> al = new ArrayList<>();
//        al.add("This");
//        al.add("is");
//        al.add("an");
        String[] words = new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        System.out.println(new TextJustification().fullJustify(words, 16));
    }
}
