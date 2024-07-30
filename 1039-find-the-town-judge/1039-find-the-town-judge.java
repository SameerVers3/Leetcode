class Solution {
    public int findJudge(int n, int[][] trust) {

        int [] in = new int[n+1];
        int [] out = new int[n+1];

        for (int [] edge: trust) {
            int u = edge[0];
            int v = edge[1];
            out[u]++;
            in[v]++;
        }

        for (int i = 1; i<=n ; i++) {
            if (in[i] == n-1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}