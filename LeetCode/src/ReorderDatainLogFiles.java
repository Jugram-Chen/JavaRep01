import java.util.ArrayList;
import java.util.Comparator;

public class ReorderDatainLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letArr = new ArrayList<>();
        ArrayList<String> digArr = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].charAt(logs[i].length() - 1) <= 57)
                digArr.add(logs[i]);
            else
                letArr.add(logs[i]);
        }
        letArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i = 4;
                while (i < chars1.length && i < chars2.length) {
                    if (chars1[i] > chars2[i]) {
                        return 1;
                    } else if (chars1[i] < chars2[i]) {
                        return -1;
                    } else {
                        i++;
                    }
                }
                if (i == chars1.length) {  //o1到头
                    return -1;
                }
                if (i == chars2.length) { //o2到头
                    return 1;
                }
                return 0;
            }
        });
        letArr.addAll(digArr);
        String[] result = letArr.toArray(new String[letArr.size()]);
        return result;
    }

    public static String[] reorderLogFiles2(String[] logs) {
        ArrayList<String> letArr = new ArrayList<>();
        ArrayList<String> digArr = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].charAt(logs[i].length() - 1) <= 57)
                digArr.add(logs[i]);
            else
                letArr.add(logs[i]);
        }
        letArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o3 = "", o4 = "", o5 = "", o6 = "";
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == ' ') {
                        o3 = o1.substring(i + 1);
                        o4 = o1.substring(0, i);
                        break;
//                        System.out.println(o1);
                    }
                }
                for (int i = 0; i < o2.length(); i++) {
                    if (o2.charAt(i) == ' ') {
                        o5 = o2.substring(i + 1);
                        o6 = o2.substring(0, i);
                        break;
//                        System.out.println(o2);
                    }
                }
                if (o3.equals(o5))
                    return o4.compareTo(o6);
                else
                    return o3.compareTo(o5);
            }
        });
        letArr.addAll(digArr);
        String[] result = letArr.toArray(new String[letArr.size()]);
        return result;
    }
}
