import java.util.ArrayList;
import java.util.List;

/**
 * @author Donglin Chen
 * @create 2020-01-26-20:47
 */
public class WordSearchII {
    ArrayList<String> al = new ArrayList<>();
    boolean[][] isVisited;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        isVisited = new boolean[board.length][board[0].length];
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    isVisited[i][j] = false;
                }
            }
            if (exist(words[k]))
                al.add(words[k]);
        }
        return al;
    }

    public boolean exist(String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && DFS(word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean DFS(String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || isVisited[i][j] == true || word.charAt(index) != board[i][j])
            return false;
        isVisited[i][j] = true;
        if (DFS(word, i + 1, j, index + 1) || DFS(word, i - 1, j, index + 1) || DFS(word, i, j + 1, index + 1) || DFS(word, i, j - 1, index + 1))
            return true;
        isVisited[i][j] = false;
        return false;
    }
}
