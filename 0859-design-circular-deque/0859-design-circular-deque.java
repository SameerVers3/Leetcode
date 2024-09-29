class MyCircularDeque {
    private LinkedList<Integer> deq;
    private int cnt;  
    private int k;  

    public MyCircularDeque(int k) {
        this.k = k;    
        this.deq = new LinkedList<>(); 
        this.cnt = 0;  
    }
    
    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;
        }
        deq.addFirst(value); 
        cnt++;  
        return true;
    }
    
    public boolean insertLast(int value) {
        if (cnt == k) {
            return false; 
        }
        deq.addLast(value);       
        cnt++;      
        return true;
    }
    
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;
        }
        deq.removeFirst();
        cnt--; 
        return true;
    }

    public boolean deleteLast() {
        if (cnt == 0) {
            return false;
        }
        deq.removeLast();   
        cnt--;           
        return true;
    }
    
    public int getFront() {
        if (cnt == 0) {
            return -1;
        }
        return deq.getFirst(); 
    }
    
    public int getRear() {
        if (cnt == 0) {
            return -1;  
        }
        return deq.getLast();           
    }
    
    public boolean isEmpty() {
        return cnt == 0;  
    }
    
    public boolean isFull() {
        return cnt == k;  
    }
}