class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num,count.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(int i = 0;i<buckets.length;i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1;f>=1 && idx<k ; f--) {
            for (int num : buckets[f]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
        return result;
    }
}
