class Solution {

    public boolean haveSubs(int[][] grid1, int[][] grid2, int i, int j) {
        if ( i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length) {
            return true;
        }

        if ( grid2[i][j] != 1) {
            return true;
        }

        grid2[i][j] = -1;

        boolean result = (grid1[i][j] == 1);

        result = result & haveSubs(grid1, grid2, i-1, j); // up
        result = result & haveSubs(grid1, grid2, i+1, j); // down
        result = result & haveSubs(grid1, grid2, i, j-1); // left
        result = result & haveSubs(grid1, grid2, i, j+1); // right

        return result;
    }
    

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0 ; i < grid1.length ; i++) {
            for (int j = 0 ; j < grid1[0].length ; j++ ){
                if (grid2[i][j] == 1 & haveSubs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
}