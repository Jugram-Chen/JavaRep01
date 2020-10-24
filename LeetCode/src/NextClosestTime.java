/**
 * @author Jugram Chen
 * @create 2020-08-07 14:19
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int mins = Integer.parseInt(time.substring(3, 5));
        while (true) {
            mins++;
            if (mins == 60) {
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
                mins = 0;
            }
            String curt = String.format("%02d:%02d", hours, mins);
            Boolean valid = true;
            for (int i = 0; i < curt.length(); i++) {
                if (time.indexOf(curt.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return curt;
            }
        }
    }
}
