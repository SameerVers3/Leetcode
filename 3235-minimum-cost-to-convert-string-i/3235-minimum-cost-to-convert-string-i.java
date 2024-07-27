class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long [][] adjMatrix = new long[26][26];

        final int k = 26;
        final int Max_Value =  Integer.MAX_VALUE;

        for(int i = 0; i< k; i++) {
            for (int  j = 0; j<k; j++) {
                adjMatrix[i][j] = Max_Value;
            }
        }

        for(int i = 0; i < original.length; i++) {
            adjMatrix[original[i] - 'a'][changed[i] - 'a'] = Math.min(adjMatrix[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }


        for (int via = 0; via < k ; via ++) {
            for(int i = 0 ; i< k ; i++) {
                for(int  j = 0; j<k ; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[via][j] + adjMatrix[i][via]);
                }
            }
        }

        long distance = 0;

        for(int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) continue;
            if (adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'] >= Max_Value) return -1;
            
            distance += adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }

        return distance;
    }
}