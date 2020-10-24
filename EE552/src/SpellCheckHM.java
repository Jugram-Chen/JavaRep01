import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jugram
 */
public class SpellCheckHM {
    public static String toLowerCaseFirstOne(String s) {//判断首字母是否大写，若是将首字母变成小写并返回，否则返回本身
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(new FileReader("usen-spelling-dict.txt"));//读入字典数据
        HashMap hm = new HashMap();
        int i = 0;
        int count = 0;
        while (s.hasNext()) {
            hm.put(s.next(), i);
            i++;
        }
        FileReader fr = new FileReader("treasureisland.txt");
        StringBuilder sb = new StringBuilder();
        int temp;
        char c;
        while ((temp = fr.read()) != -1) {//将文本内容读入
            c = (char) temp;
            sb.append(c);
        }
        //System.out.print(sb);//"\\b(?<![\\-'\"“”!.,:?])[A-Z]?[a-z]*[\\-']?[a-z]+(?![\\-'\"“”!.,:?])\\b"
        Pattern p = Pattern.compile("\\b(?<![\\-'\"”!,:?])(?![\\-'])[A-Z]?[a-z\\-']+(?<![\\-'])(?![\\-'\"“])\\b");//\b(?<![\-'"”!.,:?])(?![\-'])[A-Z]?[a-z\-']*(?<![\-'])(?![\-'"“])\b
        Matcher m = p.matcher(sb);
        ArrayList al = new ArrayList();
        while (m.find()) {
            //System.out.println(m.group());
            al.add(m.group());
        }
        //System.out.println(al);
        String change;
        for (Object obj : al) {
            change = (String) obj;
            if (hm.get(change) == null) {
                change = toLowerCaseFirstOne(change);
                if (hm.get(change) == null) {
                    count++;
                    if (count <= 100)
                        System.out.println(obj);
                }
            }
        }
        System.out.println(count);
        //System.out.println(hm.get("dsfnlsajfa"));
    }

}
