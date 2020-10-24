/**
 * @author Donglin Chen
 * @create 2019-12-17-20:48
 */
public class RainWterTrapping {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] water = new int[height.length];
        int k;
        int i;
        int j;
        for (k = 1; k < height.length - 1; k++) {
            if (k == 1) {
                if (height[0] <= height[1])
                    water[1] = 0;
                else {
                    for (j = k + 1; j < height.length - 1; j++)
                        if (height[j] > height[j + 1])
                            break;
                    water[k] = (height[0] < height[j] ? height[0] : height[j]) - height[k];
                    if (water[k] < 0)
                        water[k] = 0;
                }
            } else if (k == height.length - 2) {
                if (height[height.length - 2] >= height[height.length - 1])
                    water[height.length - 2] = 0;
                else {
                    for (i = k - 1; i > 0; i--) {
                        if (height[i] > height[i - 1])
                            break;
                    }
                    water[k] = (height[height.length - 1] < height[i] ? height[height.length - 1] : height[i]) - height[k];
                    if (water[k] < 0)
                        water[k] = 0;
                }
            } else {
                for (i = k - 1; i > 0; i--) {
                    if (height[i] > height[i - 1])
                        break;
                }
                for (j = k + 1; j < height.length - 1; j++)
                    if (height[j] > height[j + 1])
                        break;
                water[k] = (height[i] < height[j] ? height[i] : height[j]) - height[k];
                if (water[k] < 0)
                    water[k] = 0;
            }
        }
        int sum=0;
        for (i = 0; i < water.length; i++)
            //System.out.println(water[i]);
            sum=sum+water[i];
        System.out.println(sum);
    }

}
