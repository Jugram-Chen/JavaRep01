import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Donglin Chen
 * @create 2019-12-20-22:19
 */
public class NumberOfIslands {
    static class Node {
        int i;
        int j;
        char isLand;
        boolean isVisted;

        public Node(int i, int j, char isLand, boolean isVisited) {
            this.i = i;
            this.j = j;
            this.isLand = isLand;
            this.isVisted = isVisited;
        }
    }

    char[][] grid;
    Node[][] node;
    ArrayList al = new ArrayList();

    public void intialize(char[][] grid) {
        this.grid = grid;
        node = new Node[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                node[i][j] = new Node(i, j, grid[i][j], false);
            }
        }
    }

    public void DFS(int i, int j) {
        if (node[i][j].isVisted == true)
            return;
        if (node[i][j].isLand == '0')
            return;
        Stack<Node> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s.push(node[i][j]);
        node[i][j].isVisted = true;
        sb.append("(" + node[i][j].i + "," + node[i][j].j + ") ");
        while (s.empty() == false) {
            Node temp = s.pop();
            if (((temp.i + 1) < grid.length) && (node[temp.i + 1][temp.j].isLand == '1') && (node[temp.i + 1][temp.j].isVisted == false)) {
                s.push(node[temp.i + 1][temp.j]);
                node[temp.i + 1][temp.j].isVisted = true;
                sb.append("(" + (temp.i + 1) + "," + temp.j + ") ");
            }
            if (((temp.i - 1) >= 0) && (node[temp.i - 1][temp.j].isLand == '1') && (node[temp.i - 1][temp.j].isVisted == false)) {
                s.push(node[temp.i - 1][temp.j]);
                node[temp.i - 1][temp.j].isVisted = true;
                sb.append("(" + (temp.i - 1) + "," + temp.j + ") ");
            }
            if (((temp.j + 1) < grid[temp.i].length) && (node[temp.i][temp.j + 1].isLand == '1') && (node[temp.i][temp.j + 1].isVisted == false)) {
                s.push(node[temp.i][temp.j + 1]);
                node[temp.i][temp.j + 1].isVisted = true;
                sb.append("(" + temp.i + "," + (temp.j + 1) + ") ");
            }
            if (((temp.j - 1) >= 0) && (node[temp.i][temp.j - 1].isLand == '1') && (node[temp.i][temp.j - 1].isVisted == false)) {
                s.push(node[temp.i][temp.j - 1]);
                node[temp.i][temp.j - 1].isVisted = true;
                sb.append("(" + temp.i + "," + (temp.j - 1) + ") ");
            }
        }
        al.add(sb);
    }
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        intialize(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                DFS(i, j);
            }
        }
        return al.size();
    }

    public static void main(String[] args) {
        char grid[][] = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '1', '1'}};
//        char grid[][] = {{'1', '1', '1'},
//                         {'0', '1', '0'},
//                         {'1', '1', '1'}};

        NumberOfIslands soi = new NumberOfIslands();
        System.out.println(soi.numIslands(grid));
//        soi.intialize(grid);
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                soi.DFS(i, j);
//            }
//        }
//        System.out.println(soi.al);
    }
}
