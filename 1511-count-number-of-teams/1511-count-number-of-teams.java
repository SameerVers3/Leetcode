class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int [] dp1 = new int[n];
        int [] dp2 = new int[n];
        int count = 0;


        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j<n; j++) {
                if (rating[i] > rating[j]) {
                    dp1[i]++;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j<n; j++) {
                if (rating[i] > rating[j]) {
                    count += dp1[j];
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j<i; j++) {
                if (rating[i] > rating[j]) {
                    dp2[i]++;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j<i; j++) {
                if (rating[i] > rating[j]) {
                    count +=dp2[j];
                }
            }
        }

        return count;
    }
}