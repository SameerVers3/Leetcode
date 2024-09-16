class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE;
        for (int i = 0 ; i < timePoints.size() - 1 ; i++) {
            diff = Math.min(diff, getDiff(timePoints.get(i+1), timePoints.get(i)));
        }

        diff = Math.min(diff, getDiff(timePoints.get(0), timePoints.get(timePoints.size() - 1)));

        return diff;
    }

    public int getDiff(String t1, String t2) {
        String[] time1 = t1.split(":");
        String[] time2 = t2.split(":");

        int minutes1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
        int minutes2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);

        int diff = Math.abs(minutes1 - minutes2);
        return Math.min(diff, 1440 - diff);
    }
}