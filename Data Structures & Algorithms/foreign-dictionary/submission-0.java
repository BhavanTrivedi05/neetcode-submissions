class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> adj = new HashMap<>();
      for(String w: words){
        for(char c: w.toCharArray()){
            adj.putIfAbsent(c, new ArrayList<>());
        }
      }
      for (int i = 0;i<words.length - 1;i++){
        String a = words[i], b = words[i+1];
        int minLen = Math.min(a.length(), b.length());

        if (a.length()>b.length() && a.startsWith(b)) return "";

        for(int j =0;j<minLen;j++){
            if(a.charAt(j) != b.charAt(j)){
                adj.get(a.charAt(j)).add(b.charAt(j));
                break;
            }
        }
      }
      Map<Character, Boolean> state = new HashMap<>();
      StringBuilder sb = new StringBuilder();

      for (char c: adj.keySet()){
        if(dfs(c,adj, state,sb)) return "";
      }
      return sb.reverse().toString();
    }
    private boolean dfs(char c, Map<Character, List<Character>> adj,
                        Map<Character, Boolean> state, StringBuilder sb) {
        if (state.containsKey(c)) return state.get(c);   // true = on path (cycle)

        state.put(c, true);
        for (char next : adj.get(c)) {
            if (dfs(next, adj, state, sb)) return true;
        }
        state.put(c, false);
        sb.append(c);

        return false;
    }
}
