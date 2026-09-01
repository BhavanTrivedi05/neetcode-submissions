class PrefixTree {

    private static class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    private final Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            int i = c-'a';
            if (curr.children[i] == null) {
                curr.children[i] = new Node();
            }
            curr = curr.children[i];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = walk(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    private Node walk(String s){
        Node curr = root;
        for (char c : s.toCharArray()){
            int i = c - 'a';
            if (curr.children[i] == null) return null;
            curr = curr.children[i];
        }
        return curr;
    }
}
