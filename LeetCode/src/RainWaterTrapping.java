import java.util.Arrays;

/**
 * @author Donglin Chen
 * @create 2019-12-17-23:11
 */
public class RainWaterTrapping {
    public static int[] trap(int[] height){
        int size=height.length;
        int[] water = new int[size];
        int temp=0;
        int i=0;
//        while(height[i]==0)
//            i++;
        for(i=0;i<size;i++) {
            if(height[i]>temp)
                temp=height[i];
            water[i]=temp;
        }
        temp=0;
        for(i=size-1;i>=0;i--) {
            if(height[i]>temp)
                temp=height[i];
            water[i]=(water[i]<temp?water[i]:temp);
        }
        for(i=0;i<size;i++) {
            water[i]=water[i]-height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(trap(height)));
    }
}
