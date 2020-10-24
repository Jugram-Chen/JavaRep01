public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange2(int[] nums, int target) {
        int start,end;
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                start=i;
                end=i;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=target){
                        end=j-1;
                        result[0]=start;
                        result[1]=end;
                        return  result;
                    }
                    if(nums[j]==target){
                        end=j;
                    }
                }
                result[0]=start;
                result[1]=end;
                return  result;
            }
        }
        result[0]=-1;
        result[1]=-1;
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1, -1};
        int a= commonBinarySearch(nums,target);
        if(a==-1)
            return new int[]{-1, -1};
        else{
            int b=a,c=a;
            while(true){
                if(b>=0&&nums[b]==nums[a])
                    b--;
                else
                    break;
            }
            while(true){
                if(c<nums.length&&nums[c]==nums[a])
                    c++;
                else
                    break;
            }
            return new int[]{b+1,c-1};
        }
    }

    public static int commonBinarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;			//定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] result=searchRange(nums,8);
        System.out.println(result[0]+","+result[1]);
    }
}
