class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > min) {
                maxProfit = Math.max(maxProfit, (arr[i] - min));
            }
            if (arr[i] < min) min = arr[i];
        }
        return maxProfit;
    }
}