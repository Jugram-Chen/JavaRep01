import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Donglin Chen
 * @create 2019-12-21-22:56
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        if(m==0)
            return median(nums2);
        if (nums1[m - 1] <= nums2[0]) {
            int c[] = combine(nums1, nums2);
            return median(c);
        } else if (nums1[0] >= nums2[n - 1]) {
            int c[] = combine(nums2, nums1);
            return median(c);
        }
        List<Integer> a = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> b = Arrays.stream(nums2).boxed().collect(Collectors.toList());
//        int m = a.size();
//        int n = b.size();
        if ((m + n) % 2 == 1) {
            int k = (m + n + 1) / 2;
            while (true) {
                if (k / 2 == 0){
                    if(a.size()==0)
                        return b.get(0);
                    else
                        return (a.get(0) < b.get(0) ? a.get(0) : b.get(0));
                }
                if (a.get(k / 2 - 1) >= b.get(k / 2 - 1)) {
                    for (int z = 0; z < k / 2; z++)
                        b.remove(0);
                } else {
                    for (int z = 0; z < k / 2; z++)
                        a.remove(0);
                }
                k = k - k / 2;
            }
        } else {
            int a1, a2;
            int k = (m + n + 1) / 2;
            while (true) {
                if (k / 2 == 0) {
                    if(a.size()==0)
                        a1=b.get(0);
                    else
                        a1 = (a.get(0) < b.get(0) ? a.get(0) : b.get(0));
                    break;
                }
                if (a.get(k / 2 - 1) >= b.get(k / 2 - 1)) {
                    for (int z = 0; z < k / 2; z++)
                        b.remove(0);
                } else {
                    for (int z = 0; z < k / 2; z++)
                        a.remove(0);
                }
                k = k - k / 2;
            }
            k = ((m + n + 1) / 2) + 1;
            a = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            b = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            while (true) {
                if (k / 2 == 0) {
                    if(a.size()==0)
                        a2=b.get(0);
                    else
                        a2 = (a.get(0) < b.get(0) ? a.get(0) : b.get(0));
                    break;
                }
                if (a.get(k / 2 - 1) >= b.get(k / 2 - 1)) {
                    for (int z = 0; z < k / 2; z++)
                        b.remove(0);
                } else {
                    for (int z = 0; z < k / 2; z++)
                        a.remove(0);
                }
                k = k - k / 2;
            }
            return (a1 + a2) / 2.0;
        }
    }

    public int[] combine(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] c = new int[n + m];
        for (int i = 0; i < m; i++)
            c[i] = nums1[i];
        for (int i = 0; i < n; i++)
            c[i + m] = nums2[i];
        return c;
    }

    public double median(int[] c) {
        if (c.length % 2 == 1)
            return c[c.length / 2];
        else
            return (c[c.length / 2 - 1] + c[c.length / 2]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {1,3,4,5,6};
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
