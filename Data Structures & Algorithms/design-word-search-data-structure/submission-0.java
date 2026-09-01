class WordDictionary {

    private static class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new Node();
            }
            curr = curr.children[i];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int start, Node node){
        for (int i = start;i< word.length();i++){
            char c = word.charAt(i);
            if (c == '.'){
                for (Node child : node.children) {
                    if (child != null && dfs(word, i+1, child)){
                        return true;
                    }
                }
                return false;
            }
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isWord;
    }
}
