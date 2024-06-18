class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFreq = new HashMap<Integer, Integer>();

        for (int i = 0 ; i <  nums.length ; i++) {
            if (numFreq.get(nums[i]) != null) {
                int freq = numFreq.get(nums[i]);

                freq++;

                numFreq.remove(nums[i]);

                numFreq.put(nums[i], freq);
            }

            else {
                numFreq.put(nums[i], 1);
            }
        }

        int largestKey [] = new int[k];
        int largestValue [] = new int[k];

        for (int i = 0 ; i< k ; i++) {
            for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {

                int key = entry.getKey();
                int value = entry.getValue();
                
                if (value > largestValue[i]) {
                    largestKey[i] = key;
                    largestValue[i] = value;
                }
            }

            numFreq.remove(largestKey[i]);
        }

        return largestKey;

    }
}