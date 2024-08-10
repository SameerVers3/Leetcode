class Solution {

    public void DFS(char [][] grid, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'X') {
            return;
        }

        grid[i][j] = 'Y';

        DFS(grid, i, j+1);
        DFS(grid, i+1, j);
        DFS(grid, i, j-1);
        DFS(grid, i-1, j);
    }

    public int countBattleships(char[][] grid) {
        int num = 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 'X') {
                    DFS(grid, i, j);
                    num++;
                }
            }
        }

        return num;
    }
}