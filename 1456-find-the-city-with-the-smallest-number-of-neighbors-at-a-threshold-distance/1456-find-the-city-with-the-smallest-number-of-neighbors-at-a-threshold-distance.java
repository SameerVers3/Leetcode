class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // trying floyd warshall

        long [][] adjMatrix = new long[n][n];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        

        // making adj matrix

        for (int i = 0; i <  edges.length ;  i++) {
            int s = edges[i][0];
            int t = edges[i][1];
            int cost = edges[i][2];
            adjMatrix[s][t] = cost;
            adjMatrix[t][s] = cost;
        }

        
        for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < n ; j++) {
                    System.out.print(adjMatrix[i][j] + " ,");
                }
                    System.out.println();
            }

        // floyd warshal

        for (int via = 0 ; via < n; via++) {
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < n ; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[via][j] + adjMatrix[i][via]);
                }
            }
        }

        int num = -1;
        int lastReach = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reach = 0;
            for (int j = 0; j< n; j++) {
                if ( i != j && adjMatrix[i][j] <= distanceThreshold) {
                    reach++;
                }
            }

            if (reach <= lastReach) {
                num = i;
                lastReach = reach;
            }
        }

        return num;
    }
}