class Solution {
    
    public void solve(int curr, List<Integer> result, int limit) {
        if (curr > limit) {
            return;
        }

        result.add(curr);

        for (int i = 0 ; i <= 9 ; i++) {
            int newNum = (curr * 10) + i;
            if (newNum > limit) {
                return;
            }
            solve(newNum, result, limit);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++) {
            solve(i, result, n);
        }
        return result;
    }
}