class Solution {
    public int dfs(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0){
            return 0;
        }

        if(grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return 1+ dfs(grid, i + 1, j)+
        dfs(grid, i - 1, j)+
        dfs(grid, i, j + 1)+
        dfs(grid, i, j - 1);
    }
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count = Math.max(count, dfs(grid,i,j));
                }
            }
        }
        return count;
    }
}
