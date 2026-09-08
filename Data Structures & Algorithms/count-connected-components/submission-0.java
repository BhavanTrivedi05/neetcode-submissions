class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int components = n;
        for (int[] e:edges){
            if(union(parent,size,e[0],e[1])){
                components--;
            }
        }
        return components;
    }

    private int find(int[] parent, int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int[] parent, int[] size, int a, int b){
        int ra = find(parent,a),rb = find(parent,b);
        if(ra == rb) return false;
        if (size[ra] < size[rb]){
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }
}
