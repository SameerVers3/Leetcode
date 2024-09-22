class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while(k > 0) {
            int count = Count(curr, curr+1, n);

            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }

    public int Count(long curr, long next, int n) {
        int countNum = 0;
        while (curr <= n) {
            countNum += (next - curr);

            curr *= 10;
            next *= 10;

            next = Math.min(next, n+1);
        }       
        return countNum; 
    }
}