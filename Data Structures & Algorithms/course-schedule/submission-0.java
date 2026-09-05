class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int [] p: prerequisites){
            adj.get(p[0]).add(p[1]);
        }

        int[] state = new int[numCourses];

        for (int i = 0;i< numCourses;i++){
            if (!dfs(i,adj,state)) return false;
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adj,int[] state){
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;
        for (int pre: adj.get(course)){
            if (!dfs(pre, adj, state)) return false;
        }
        state[course] = 2;
        return true;
    }
}
