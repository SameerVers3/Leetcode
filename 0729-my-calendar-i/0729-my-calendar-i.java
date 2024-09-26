class MyCalendar {

    List<int[]> cal;

    public MyCalendar() {
        cal = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] curr : cal) {
            if (!(end <= curr[0] || start >= curr[1])) {
                return false;
            }
        }

        cal.add(new int[]{start, end});
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */