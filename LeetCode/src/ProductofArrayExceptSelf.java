import java.util.Arrays;

/**
 * @author Donglin Chen
 * @create 2019-12-25-21:14
 */
public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] temp1=new int[nums.length];
        int[] temp2=new int[nums.length];
        int[] temp3=new int[nums.length];
        temp1[0]=1;
        temp2[nums.length-1]=1;
        for(int i=1;i<nums.length;i++)
            temp1[i]=temp1[i-1]*nums[i-1];
        for(int i=nums.length-2;i>=0;i--)
            temp2[i]=temp2[i+1]*nums[i+1];
        for(int i=0;i<nums.length;i++)
            temp3[i]=temp1[i]*temp2[i];
        return temp3;
    }

    public static void main(String[] args) {
        int[] nums={5,0};
        System.out.println(Arrays.toString(ProductofArrayExceptSelf.productExceptSelf(nums)));
    }
}
