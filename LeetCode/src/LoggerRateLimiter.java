import java.util.HashMap;

/**
 * @author Jugram Chen
 * @create 2020-08-06 15:18
 */
public class LoggerRateLimiter {
    class Logger {
        HashMap<String,Integer> hm;
        /** Initialize your data structure here. */
        public Logger() {
            hm=new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!hm.containsKey(message)){
                hm.put(message,timestamp);
                return  true;
            }
            else{
                int temp=hm.get(message);
                if(timestamp - temp<10){
//                    hm.put(message,timestamp);
                    return  false;
                }
                else{
                    hm.put(message,timestamp);
                    return  true;
                }
            }

        }
    }
}
