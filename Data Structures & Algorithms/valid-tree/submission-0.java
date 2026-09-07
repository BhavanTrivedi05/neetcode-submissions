class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int [] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);        
        }
        boolean[] visited = new boolean[n];
        dfs(0, adj,visited);

        for (boolean v : visited){
            if(!v) return false;
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int next: adj.get(node)){
            if(!visited[next]){
                dfs(next, adj, visited);
            }
        }
    }
}
