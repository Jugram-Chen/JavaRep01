import java.util.ArrayList;

public class RottingOranges {
    ArrayList<Integer[][]> al = new ArrayList<>();

    public static boolean equalArray(Integer[][] arr1, Integer[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j])
                    return false;
            }
        }
        return true;
    }

    public static boolean containsOne(Integer[][] arr1){
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] ==1)
                    return true;
            }
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        Integer[][] temp = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        al.add(temp);
        while (true) {
            Integer[][] temp1 = al.get(al.size() - 1);
            Integer[][] temp2 = new Integer[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    temp2[i][j] = temp[i][j];
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (temp1[i][j] == 2) {
                        temp2[i][j] = 2;
                        if ((i - 1) >= 0 && temp1[i - 1][j] == 1)
                            temp2[i - 1][j] = 2;
                        if ((i + 1) < grid.length && temp1[i + 1][j] == 1)
                            temp2[i + 1][j] = 2;
                        if ((j - 1) >= 0 && temp1[i][j - 1] == 1)
                            temp2[i][j - 1] = 2;
                        if ((j + 1) < grid[0].length && temp1[i][j + 1] == 1)
                            temp2[i][j + 1] = 2;
                    }
                }
            }
            if (equalArray(temp1, temp2)) {
                if(containsOne(temp2))
                    return -1;
                else
                    return al.size() - 1;
            }
            al.add(temp2);
        }
    }
}
