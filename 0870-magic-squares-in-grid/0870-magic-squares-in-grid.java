class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        
        for (int i = 0; i <= grid.length - 3 ; i++) {
            System.out.println("at least working to na");
            for (int j = 0; j <= grid[0].length - 3 ; j++) {
                
            System.out.println(grid[i][j]);
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagicGrid(int[][] grid, int r, int c) {

        Set<Integer> map = new HashSet<Integer>();
        for (int i = r ; i < r + 3 ; i++) {

        System.out.println("--------");
            for (int j = c ; j < c + 3 ; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || map.contains(num)) {
                    return false;
                }
                else {
                    map.add(num);
                }
            } 
        }

        int rowSum = grid[r][c] + grid[r][c+1] + grid[r][c+2];

        for (int i = 0; i< 3 ; i++) {
            if (grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != rowSum) {
                return false;
            }

            if (grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != rowSum) {
                return false;
            }
        }

        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != rowSum) {
            return false;
        } 

        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != rowSum) {
            return false;
        } 

        return true;
    }
}