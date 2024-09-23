class Solution {
    int[] t = new int[51];

    public int solve(int i, String s, Set<String> st, int n) {
        if (i >= n) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int res = 1 + solve(i + 1, s, st, n);

        for (int j = i; j < n; j++) {
            String curr = s.substring(i, j + 1);
            if (st.contains(curr)) {
                res = Math.min(res, solve(j + 1, s, st, n));
            }
        }

        return t[i] = res;
    }

    public int minExtraChar(String s, List<String> dict) {
        int n = s.length();
        Arrays.fill(t, -1);
        Set<String> st = new HashSet<>(dict);
        return solve(0, s, st, n);
    }
    
    public int minExtraChar(String s, String[] dictArray) {
        return minExtraChar(s, Arrays.asList(dictArray));
    }
}
