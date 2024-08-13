class Solution {

    public void solve(int []arr, List<List<Integer>> result, List<Integer> curr, int k, int index) {
        if (k < 0) {
            return;
        }

        if (k == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index ; i<arr.length ; i++) {
            if (i > index && arr[i] == arr[i-1]) {
                continue;
            }

            curr.add(arr[i]);
            solve(arr, result, curr, k-arr[i], i+1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(arr);
        solve(arr, result, curr, k, 0);
        return result;
    }
}