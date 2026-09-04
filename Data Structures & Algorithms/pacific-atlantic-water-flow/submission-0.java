class Solution {
private int rows,cols;
private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c = 0;c<cols;c++){
            dfs(0,c,pacific);
            dfs(rows-1,c,atlantic);
        }
        for(int r = 0;r<rows;r++){
            dfs(r,0,pacific);
            dfs(r,cols-1,atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0;r<rows;r++){
            for (int c = 0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                } 
            }
        }
        return res;
    }

    private void dfs(int r,int c, boolean[][] visited){
        visited[r][c] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d: dirs){
            int nr = r+d[0],nc = c+d[1];
            if(nr<0 || nc < 0 || nr>= rows || nc >= cols) continue;
            if(visited[nr][nc]) continue;
            if(heights[nr][nc] < heights[r][c]) continue;
            dfs(nr,nc,visited);
        }
    }
}
