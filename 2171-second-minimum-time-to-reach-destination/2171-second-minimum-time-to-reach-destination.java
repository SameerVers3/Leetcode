class Solution {

    // for priority queue
    class Element {
        int timePassed;
        int node;

        public Element(int timePassed, int node) {
            this.timePassed = timePassed;
            this.node = node;
        }
    }

    static class NodeComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
           return Integer.compare(e1.timePassed, e2.timePassed);
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {

       Map<Integer, List<Integer>> adjLists = new HashMap<>();

        for (int [] edge :  edges) {
            int u = edge[0];
            int v = edge[1];
            adjLists.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            adjLists.computeIfAbsent(v, value -> new ArrayList<>()).add(u);
        }

        int [] d1 = new int[n+1]; // min time
        int [] d2 = new int[n+1]; // 2nd min time

        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        PriorityQueue<Element> minHeap = new PriorityQueue<>(new NodeComparator());

        minHeap.offer(new Element(0, 1));

        d1[1] = 0;

        while (!minHeap.isEmpty()) {
            
            Element element = minHeap.poll();
            int timePassed = element.timePassed;
            int node = element.node;

            // if node is n and found d2[n] which is change :  success
            if (node == n && d2[n] !=  Integer.MAX_VALUE) {
                return d2[n];
            }

            // interval calculation
            int interval = timePassed/change;
            int waitTime = (interval % 2 == 1) ? (interval + 1) * change : timePassed;

            // visiting nodes here
            for (int nbr : adjLists.get(node) ) {
                int newTime = waitTime + time;
                if (d1[nbr] > newTime) {
                    d2[nbr] = d1[nbr];
                    d1[nbr] = newTime;
                    minHeap.offer(new Element(newTime, nbr));
                }
                else if (d2[nbr] > newTime && d1[nbr] != newTime) {
                    d2[nbr] = newTime;
                    minHeap.offer(new Element(newTime, nbr));
                }
            }
        }

        return -1;
    }
}