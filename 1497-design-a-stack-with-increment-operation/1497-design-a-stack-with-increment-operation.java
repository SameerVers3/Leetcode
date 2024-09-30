class CustomStack {

    int n;
    int [] stack;
    int top_idx = -1;

    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new int[n];
    }
    
    public void push(int x) {
        if ( top_idx + 1 < n ) {
            stack[++top_idx] = x;
        }
    }
    
    public int pop() {
        if (top_idx < 0) {
            return -1;
        }

        int el = stack[top_idx];
        stack[top_idx--] = 0;

        return el;
    }
    
    public void increment(int k, int val) {
        int min = Math.min(k, top_idx+1);

        for (int i = 0 ; i < min ; i++) {
            stack[i] += val;
        }
    }
}
