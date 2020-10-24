/**
 * @author Donglin Chen
 * @create 2020-01-06-22:32
 */
public class SearchInRotatedSortedArray {
    //    public int search(int[] nums, int target) {
//        int start = 0, end = nums.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) return mid;
//            else if (nums[mid] >= nums[start]) {
//                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
//                else start = mid + 1;
//            }
//            else {
//                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
//                else end = mid - 1;
//            }
//        }
//        return -1;
//    }
//    public static int find_rotate_index(int nums[],int left,int right,int target){
//        if (nums[left] < nums[right])
//            return 0;
//
//        while (left <= right) {
//            int pivot = (left + right) / 2;
//            if (nums[pivot] > nums[pivot + 1])
//                return pivot + 1;
//            else {
//                if (nums[pivot] < nums[left])
//                    right = pivot - 1;
//                else
//                    left = pivot + 1;
//            }
//        }
//        return 0;
//    }
//    public int search(int[] nums, int target) {
//
//    }
    static int rotate = 0;

    public static void find1(int nums[], int left, int right) {
        if (nums[0] < nums[nums.length - 1]) {
            rotate = 0;
            return;
        }
        if (nums[left] > nums[left + 1])
            rotate = left + 1;
        else {
            int pivot = (left + right) / 2;
            if (nums[left] < nums[pivot])
                find1(nums, pivot, right);
            else
                find1(nums, left, pivot);
        }
    }

    public static int binarySearch(int nums[], int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                return binarySearch(nums, left, mid - 1, target);
            return binarySearch(nums, mid + 1, right, target);
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        else if(nums.length<10){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target)
                    return i;
            }
            return -1;
        }
        find1(nums, 0, nums.length);
        if(rotate==0)
            return binarySearch(nums, 0, nums.length, target);
        else if (target > nums[rotate - 1] && target < nums[rotate])
            return -1;
        else if (target <= nums[rotate-1]&&target >= nums[0])
            return binarySearch(nums, 0, rotate-1, target);
        else if (target >= nums[rotate]&&target <= nums[nums.length-1]) {
            return binarySearch(nums, rotate, nums.length, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {  1, 3, 5, 7, 9, 11};
        //int[] nums = {0, 1, 2, 3, 4, 5, 6, -1};
        //find1(nums, 0, nums.length);
        for(int i:nums)
            System.out.println(search(nums,i));
    }
}
