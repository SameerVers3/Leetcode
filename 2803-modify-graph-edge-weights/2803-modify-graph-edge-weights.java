class Solution {
    static final int LV = (int) 2e9;

    public long dijkstra(int n, int [][] edges, int src, int dest) {
        Map<Long, List<long[]>> adj = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.computeIfAbsent((long) u, k -> new ArrayList<>()).add(new long[]{v, wt});
                adj.computeIfAbsent((long) v, k -> new ArrayList<>()).add(new long[]{u, wt});
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] result = new long[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(result, Long.MAX_VALUE);

        result[src] = 0;

        pq.offer(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int currNode = (int) curr[1];

            if (visited[currNode]) continue;
            visited[currNode] = true;

            if (!adj.containsKey((long) currNode)) continue;

            for (long[] neighbor : adj.get((long) currNode)) {
                int nbr = (int) neighbor[0];
                long weight = neighbor[1];

                if (result[nbr] > currDist + weight) {
                    result[nbr] = currDist + weight;
                    pq.offer(new long[]{result[nbr], nbr});
                }
            }
        }

        return result[dest];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int des, int target) {
        long curShortDis = dijkstra(n, edges, src, des);

        if (curShortDis < target) {
            return new int [0][];
        }

        boolean matched = (target == curShortDis) ? true : false;

        for (int [] edge: edges) {
            if (edge[2] == -1) {
                edge[2] = (matched) ? LV : 1;

                if (!matched) {
                    long newShort = dijkstra(n, edges, src, des);
                    if (newShort <= target) {
                        matched = true;
                        edge[2] += (target - newShort);
                    }
                }
            }
        }

        if (! matched) {
            return new int [0][];
        }

        return edges;
    }
}