/**
 * @author Donglin Chen
 * @create 2020-01-17-18:42
 */
public class MergeSortedArray {
    //    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        ArrayList<Integer> al=new ArrayList<>();
//        for(int i=0;i<m;i++)
//            al.add(nums1[i]);
//        for(int i=0;i<n;i++)
//            al.add(nums2[i]);
//        Collections.sort(al);
//        for(int j=0;j<al.size();j++)
//            nums1[j]=al.get(j);
//    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int index=m+n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[index]=nums1[index1];
                index1--;
                index--;
            }
            else{
                nums1[index]=nums2[index2];
                index2--;
                index--;
            }
        }
        while(index2>=0){
            nums1[index]=nums2[index2];
            index2--;
            index--;
        }

    }


}
