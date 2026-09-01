class Solution {
    private static class Node {
        Node[] children = new Node[26];
        String word = null;
    }
    private char[][] board;
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        Node root = new Node();

        for (String w : words){
            Node curr = root;
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if (curr.children[i] == null) curr.children[i] = new Node();
                curr = curr.children[i];
            }
            curr.word = w;
        }

        for(int r = 0;r< board.length; r++){
            for (int c = 0;c<board[0].length; c++) {
                dfs(r,c,root);
            }
        }
        return res;
    }
    private void dfs(int r,int c,Node node){
        if(r<0 || c<0 || r>= board.length || c>= board[0].length) return;

        char ch = board[r][c];
        if(ch == '#') return;

        Node next = node.children[ch-'a'];
        if (next == null) return;
        if(next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        dfs(r+1,c,next);
        dfs(r-1,c,next);
        dfs(r,c+1,next);
        dfs(r,c-1,next);
        board[r][c] = ch;
    }
}
