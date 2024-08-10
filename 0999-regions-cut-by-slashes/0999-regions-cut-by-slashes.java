class Solution {

    public void DFS(int [][]grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }

        grid[i][j] = -1;

        DFS(grid, i-1, j);
        DFS(grid, i, j+1);
        DFS(grid, i+1, j);
        DFS(grid, i, j-1);
    }

    public int regionsBySlashes(String[] arr) {
        int n = arr[0].length() * 3;
        int [][] grid = new int[n][n];
        int r = 0, c = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ;  j < arr[i].length() ; j++ ) {
                if (arr[i].charAt(j) == ' ') {

                }
                else if (arr[i].charAt(j) == '/') {
                    grid[r][c+2] = 1;
                    grid[r+1][c+1] = 1;
                    grid[r+2][c] = 1;
                }
                else {
                    grid[r][c] = 1;
                    grid[r+1][c+1] = 1;
                    grid[r+2][c+2] = 1;
                }
                c+=3;
            }
            r += 3;
            c = 0;
        } 

        int sections = 0;

        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0 ;  j < grid[i].length ; j++) {
                if (grid[i][j] == 0) {
                    DFS(grid, i, j);
                    sections++;
                }
            }
        }

        return sections;
    }
}