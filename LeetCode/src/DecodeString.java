import java.util.Stack;

public class DecodeString {
    int index = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = (num * 10) + (c - '0');
            } else if (c == '[') {
                index++;
                String decoded = decodeString(s);
                for (int j = 0; j < num; j++) {
                    sb.append(decoded);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
            index++;
        }
        return sb.toString();
    }
}
