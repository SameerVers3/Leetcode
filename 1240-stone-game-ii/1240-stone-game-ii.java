class Solution {
    int n;
    int [][][] mem;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        mem = new int[2][101][101];

        for (int i = 0 ; i < 2 ; i++) {
            for (int j = 0 ; j < 101 ; j++) {
                for (int k = 0 ; k < 101 ;  k++) {
                    mem[i][j][k] = -1;
                }
            }
        }

        return solve(piles, 0, 1, 1);
    }

    public int solve(int [] piles, int i, int M, int turn) {
        if (i >= n) {
            return 0;
        }

        if (mem[turn][i][M] != -1) {
            return mem[turn][i][M];
        }

        int result = (turn == 1) ? -1 : Integer.MAX_VALUE;
        int stone = 0;

        for (int x = 1 ; x <= Math.min(2*M, n-i) ; x++) {
            stone += piles[i+x-1];

            if (turn == 1) {
                result = Math.max(result, stone + solve(piles, i+x, Math.max(M, x), 0));
            } else {
                result = Math.min(result, solve(piles, i+x, Math.max(M, x), 1));
            }
        }

        mem[turn][i][M] = result;

        return result;
    }
}