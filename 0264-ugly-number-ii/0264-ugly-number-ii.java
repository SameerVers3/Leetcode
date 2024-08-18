class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();

        heap.add(1L);
        seen.add(1L);
        
        long currentUgly = 1;
        
        for (int i = 1; i <= n; i++) {
            currentUgly = heap.poll();
            long nextUgly2 = currentUgly * 2;
            long nextUgly3 = currentUgly * 3;
            long nextUgly5 = currentUgly * 5;
            
            if (seen.add(nextUgly2)) {
                heap.add(nextUgly2);
            }
            if (seen.add(nextUgly3)) {
                heap.add(nextUgly3);
            }
            if (seen.add(nextUgly5)) {
                heap.add(nextUgly5);
            }
        }
        return (int) currentUgly;
    }
}
