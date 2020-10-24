/**
 * @author Donglin Chen
 * @create 2020-01-07-22:02
 */
public class BestTimetoBuyandSellStock {
    //    public static int maxProfit(int[] prices) {
//        if(prices.length<=1)
//            return 0;
//        int Gmax=0;
//        ArrayList<Integer> maxs = new ArrayList<>();
//        for(int i=0;i<prices.length-1;i++){
//            int Lmax=0;
//            for(int j=i+1;j<prices.length;j++){
//                Lmax=Math.max(Lmax,prices[j]-prices[i]);
//            }
//            maxs.add(Lmax);
//        }
//        Gmax= Collections.max(maxs);
//        return Gmax;
//    }
    public static int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int Gmax=0;
        int tempMin=prices[0];
        int maxDif=prices[1]-prices[2];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=tempMin)
                tempMin=prices[i];
            else
                Gmax=Math.max(prices[i]-tempMin,Gmax);
        }
        return Gmax;
    }
        public static void main (String[]args){
            int[] prices = {7,1,5,3,6,4};
            int Gmax = maxProfit(prices);
            System.out.println(Gmax);
        }
    }
