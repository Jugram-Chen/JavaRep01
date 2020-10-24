import java.util.*;

/**
 * @author Donglin Chen
 * @create 2020-01-28-23:22
 */
public class TheSkylineProblem {
//    public static List<List<Integer>> getSkyline(int[][] buildings) {
//        if(buildings==null||buildings.length==0)
//            return new ArrayList<List<Integer>>();
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i=0;i<buildings.length;i++){
//            for(int j=buildings[i][0];j<buildings[i][1];j++){
//                if(hm.get(j)==null)
//                    hm.put(j,buildings[i][2]);
//                else if(hm.get(j)<buildings[i][2])
//                    hm.put(j,buildings[i][2]);
//            }
//        }
//        int max=Collections.max(hm.keySet());
//        for(int i=0;i<=max+1;i++){
//            if(hm.get(i)==null)
//                hm.put(i,0);
//        }
//        System.out.println(hm);
//        List<List<Integer>> al=new ArrayList<>();
//        if(hm.get(0)!=0) {
//            al.add(List.of(0,hm.get(0)));
//        }
//        for(int i=1;i<hm.size();i++){
//            if(hm.get(i)!=hm.get(i-1))
//                al.add(List.of(i,hm.get(i)));
//        }
////        System.out.println(al);
//        return al;
//    }
public static List<List<Integer>> getSkyline(int[][] buildings) {
    int last=0;
    ArrayList<Integer> al1=new ArrayList<>();
    ArrayList<List<Integer>> al2=new ArrayList<>();
    for(int i=0;i<buildings.length;i++){
        al1.add(buildings[i][0]);
        al1.add(-buildings[i][1]);
        last=Math.max(last,buildings[i][1]);
    }
    Collections.sort(al1, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(Math.abs(o1),Math.abs(o2));
        }
    });
    System.out.println(al1);
    System.out.println(last);
    return new ArrayList<List<Integer>>();

}
    public static void main(String[] args) {
        int buildings[][]={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//        int buildings[][]={{0,2147483647,2147483647}};
        getSkyline(buildings);
    }
}
