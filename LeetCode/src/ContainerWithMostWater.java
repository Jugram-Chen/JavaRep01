/**
 * @author Donglin Chen
 * @create 2020-01-12-20:44
 */
public class ContainerWithMostWater {
//    public static int maxArea(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int maxArea = 0;
//        while (right - left > 0) {
//            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
//            if (height[left] < height[right])
//                left++;
//            else
//                right--;
//        }
//        return maxArea;
//    }

    public static int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                max=Math.max(max,Math.min(height[i], height[j]) * (j-i));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
