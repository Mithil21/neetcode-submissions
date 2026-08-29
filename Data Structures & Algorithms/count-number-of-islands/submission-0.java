class Solution {
    public boolean helper(char[][] graph, boolean[][] visited, int i , int j){
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length){
            return false;
        }
        
        if(visited[i][j]){
            return false;
        }

        if(graph[i][j] == '0') return false;

        visited[i][j] = true;
        graph[i][j] = '0';

        helper(graph, visited, i + 1,j);
        helper(graph, visited, i - 1,j);
        helper(graph, visited, i,j + 1);
        helper(graph, visited, i,j - 1);

        
        return true;
    }
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    if(helper(grid,visited,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
