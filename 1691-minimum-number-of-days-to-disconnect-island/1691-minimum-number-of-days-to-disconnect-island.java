class Solution {
    int m, n;

    public void DFS(int [][] grid, boolean [][] vis, int i , int j) {
        if ( i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || grid[i][j] == 0) {
            return;
        }

        vis[i][j] = true;

        DFS(grid, vis, i, j+1);
        DFS(grid, vis, i+1, j);
        DFS(grid, vis, i, j-1);
        DFS(grid, vis, i-1, j);
    }

    public int numberOfIslands(int[][] grid) {
        int islands = 0;
        boolean [][] vis = new boolean[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    DFS(grid, vis, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int islands = numberOfIslands(grid);
        if (islands == 0 || islands > 1) {
            return 0;
        }

        for (int i = 0 ; i < m ; i++) {
            for  (int j  = 0 ; j < n ; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    islands = numberOfIslands(grid);
                    if (islands == 0) {
                        return 1;
                    }
                    if (islands >= 2) {
                        return 1;
                    }
                    else {
                        grid[i][j] = 1;
                    }
                }
            }
        }
        return 2;
    }
}