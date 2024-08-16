class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int maxDifference = Integer.MIN_VALUE;
        int first, last;
        for (int i = 1 ; i < arrays.size() ; i++) {
            first = arrays.get(i).get(0);
            last = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDifference = Math.max(maxDifference, Math.max(Math.abs(last - min), Math.abs(first - max)));

            min = Math.min(min, first);
            max = Math.max(max, last);
        }

        return maxDifference;
    }
}