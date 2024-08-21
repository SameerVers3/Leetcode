class Solution {
    int n;
    int [][] mem;


    public int strangePrinter(String s) {
        n = s.length();

        mem = new int[n+1][n+1];

        for (int i = 0 ; i < n+1 ; i++) {
            for (int j = 0  ; j  < n+1 ; j++) {
                mem[i][j] = -1;
            }
        }

        return solve(0, n-1 , s);
    }

    public int solve(int l, int r, String s) {
        if (l == r) {
            return 1;
        }

        if (l > r) {
            return 0;
        }

        if (mem[l][r] != -1) {
            return mem[l][r];
        }

        int i = l+1;

        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }

        if (i == r+1) {
            return 1;
        }

        int b = 1 + solve(i, r, s);

        int c = Integer.MAX_VALUE;

        for(int j = i ;  j <= r ; j++) {
            if (s.charAt(j) == s.charAt(l) ) {
                int ans = solve(i, j-1, s) + solve(j, r, s);

                c = Math.min(c, ans);
            }
        }

        ;

        return mem[l][r] = Math.min(c, b);
    }
}