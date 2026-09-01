class Solution {
    private char[][] board;
    private String word; 

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int r = 0; r< board.length; r++){
        for (int c = 0; c<board[0].length; c++) {
                if (dfs(r,c,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int i){
        if (i == word.length())return true;
        if (r<0 || c<0 || r>= board.length || c>= board[0].length) return false;
        if (board[r][c] != word.charAt(i)) return false;

        char saved = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(r + 1, c, i + 1)
                     || dfs(r - 1, c, i + 1)
                     || dfs(r, c + 1, i + 1)
                     || dfs(r, c - 1, i + 1);
        board[r][c] = saved;
        return found;
    }
}
