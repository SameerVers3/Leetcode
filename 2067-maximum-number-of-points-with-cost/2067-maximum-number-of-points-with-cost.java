class Solution {
    public long maxPoints(int[][] points) {
        long [] prev = new long[points[0].length];

        long [] dpRight = new long[points[0].length];
        long [] dpLeft = new long[points[0].length];

        for (int i = 0 ; i < points.length ; i++) {
            
            dpRight[0] = prev[0];
            for (int j = 1 ; j < points[i].length ; j++) {
                dpRight[j] = Math.max(prev[j], dpRight[j-1] - 1);
            }

            dpLeft[points[i].length - 1] = prev[points[i].length - 1];
            for (int j = points[i].length - 2 ; j >= 0 ; j--) {
                dpLeft[j] = Math.max(prev[j], dpLeft[j+1] - 1);
            }

            for (int j = 0 ; j < points[i].length ; j++) {
                prev[j] = points[i][j] + Math.max(dpRight[j] , dpLeft[j]);
            }
        }

        long max = prev[0];

        for (int i = 0 ; i < prev.length ; i++) {
            if (prev[i] > max) {
                max = prev[i];
            }
        }

        return max;
    }
}