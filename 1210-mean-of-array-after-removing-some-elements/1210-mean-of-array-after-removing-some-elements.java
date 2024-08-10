class Solution {
    public double trimMean(int[] arr) {
        double n =  0.05 * arr.length ;
        double sum = 0;
        Arrays.sort(arr);
        int j = 0;
        for (int i = (int)n ; i < arr.length - n ; i++) {
            sum += arr[i];
            j++;
        }
        return (sum / j);
    }
}