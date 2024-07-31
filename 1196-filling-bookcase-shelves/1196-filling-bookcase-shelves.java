class Solution {
    public int t[][] = new int[1001][1001];

    public int minHeightShelves(int[][] books, int shelfWidth) {
        for(int i = 0; i < 1001; i++) {
            for(int j = 0; j < 1001; j++) {
                t[i][j] = -1;
            }
        }

        return Solve(books, 0, shelfWidth, 0, shelfWidth);
    }
    
    public int Solve(int [][] books, int i, int rem_width, int maxHt, int shelfWidth) {
        if (i >= books.length) {
            return maxHt;
        }

        if (t[i][rem_width] != -1){
            return t[i][rem_width];
        }

        int w = books[i][0];
        int h = books[i][1];
        int keep = Integer.MAX_VALUE , skip = Integer.MAX_VALUE;

        if (w <= rem_width) {
            keep = Solve(books, i+1, rem_width-w , Math.max(h, maxHt), shelfWidth);
        }

        skip = maxHt + Solve(books, i+1, shelfWidth-w , h, shelfWidth);

        return t[i][rem_width] = Math.min(keep, skip);
    }
}