class MyCalendarTwo {

    List<int[]> doubleOverlappedRegion;
    List<int[]> overallBookings;

    public MyCalendarTwo() {
        doubleOverlappedRegion = new ArrayList<>();
        overallBookings = new ArrayList<>();
    }
    
    private boolean checkOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    private int[] findOverlappedRegion(int start1, int end1, int start2, int end2) {
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }

    public boolean book(int start, int end) {
        for (int[] region : doubleOverlappedRegion) {
            if (checkOverlap(region[0], region[1], start, end)) {
                return false;
            }
        }

        for (int[] booking : overallBookings) {
            if (checkOverlap(booking[0], booking[1], start, end)) {
                doubleOverlappedRegion.add(findOverlappedRegion(booking[0], booking[1], start, end));
            }
        }
        overallBookings.add(new int[]{start, end});
        return true;
    }
}