public class TicTacToe {
    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = 0;
        }
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        return check(row, col, player);
    }

    public int check(int a, int b, int c) {
        int flag = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[a][i] != c)
                break;
            else
                flag++;
        }
        if (flag == board.length)
            return c;
        flag = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][b] != c)
                break;
            else
                flag++;
        }
        if (flag == board.length)
            return c;
        flag = 0;
        if (a == b) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != c)
                    break;
                else
                    flag++;
            }
            if (flag == board.length)
                return c;
            flag = 0;
        }
        if((a+b)==(board.length-1)){

            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length-1-i] != c){
                    break;
                }
                else{
                    System.out.println(i);
                    flag++;
                }
            }
            System.out.println(flag);
            if (flag == board.length)
                return c;
            flag = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ttt=new TicTacToe(3);
        ttt.board[0][2]=1;
        ttt.board[1][1]=1;
        ttt.board[2][0]=1;
        System.out.println(ttt.check(1,1,1));
    }
}
