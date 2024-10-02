import java.util.Arrays;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] arr2 = arr.clone();
        int[] res = new int[n];
        
        Arrays.sort(arr2);
        
        int[] ranks = new int[n];
        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr2[i] != arr2[i - 1]) {
                ranks[i] = rank++;
            } else {
                ranks[i] = ranks[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            res[i] = findRank(arr2, arr[i], ranks);
        }

        return res;
    }

    private int findRank(int[] sortedArr, int value, int[] ranks) {
        int left = 0, right = sortedArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArr[mid] == value) {
                return ranks[mid];
            }
            if (sortedArr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
