/**
 * @author Jugram Chen
 * @create 2020-08-25 16:06
 */
public class NumberofShipsinaRectangle {//四分查找法
//    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
//        if (!sea.hasShips(topRight, bottomLeft))
//            return 0;
//
//        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
//            if (sea.hasShips(topRight, bottomLeft))
//                return 1;
//        }
//
//        int midX = (bottomLeft[0] + topRight[0]) / 2; // middle of x axis
//        int midY = (bottomLeft[1] + topRight[1]) / 2; // middle of y axis
//
//        // need add 1 because we are not dividing the rectangle into 4 even parts, otherwise we get overflow
//        return countShips(sea, new int[]{midX, midY}, bottomLeft) +
//                countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]}) +
//                countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
//                countShips(sea, topRight, new int[]{midX + 1, midY + 1});
//    }
}

