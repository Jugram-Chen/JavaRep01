import java.io.FileReader;
import java.io.IOException;

/**
 * @author Donglin Chen
 * @create 2020-02-23-13:53
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("hello.txt");
        char[] buf=new char[5];
        int len;
        while((len=fr.read(buf))!=-1){
            for(int i=0;i<len;i++)
                System.out.println(buf[i]);
        }
    }


}
