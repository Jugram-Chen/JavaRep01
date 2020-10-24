
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Jugram
 */
public class QuicksortHM {
    public void quicksort(int[] x,int left, int right){
        if(right-left<2)
            return;
        int pivot=(x[left]+x[right])/2; //pivot为基准量
        int i = left;
        int j = right;
        while(i < j) { //顺序很重要，要先从右边开始找
            while(x[j] >= pivot )
                j--;
            while(x[i] < pivot )//再找右边的
                i++;
            if(i < j)//交换两个数在数组中的位置
            {
                int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }
        quicksort(x,left, i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(x,i, right);//继续处理右边的 ，这里是一个递归的过程
    }
    public static void main(String[] args) throws IOException{
        QuicksortHM asd=new QuicksortHM();
        FileReader fr=new FileReader("EE593\\hw2a.dat");
        Scanner s=new Scanner(fr);
        //while(s.hasNext() ){
        int looptime=s.nextInt();
        System.out.println(looptime);
        for(int j=0;j<looptime-1;j++){
            int arraylength=s.nextInt();
            System.out.println(arraylength);
            int[] array=new int[arraylength];
            for(int h=0;h<arraylength;h++){
                array[h]=s.nextInt();
                System.out.print(array[h]+" ");
            }
            System.out.println();
            asd.quicksort(array,0,array.length-1);
            for(int h=0;h<arraylength;h++)
                System.out.print(array[h]+" ");
            System.out.println();
        }
        //int temp=s.nextInt();
        //System.out.println(temp);
        int arraylength=s.nextInt();
        System.out.println(arraylength);
        int[] array=new int[arraylength];
        for(int h=0;h<arraylength;h++){
            array[h]=s.nextInt();
            System.out.print(array[h]+" ");
        }
        asd.quicksort(array,0,array.length-1);
        // }
        fr.close();
    }
}
