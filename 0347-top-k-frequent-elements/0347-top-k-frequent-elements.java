class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums) m.put(n, m.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> m.get(a) - m.get(b));

        for (int n : m.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = pq.poll();
        return ans;
    }
}
