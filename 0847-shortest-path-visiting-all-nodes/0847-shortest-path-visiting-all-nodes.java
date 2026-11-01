class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisited = (1 << n) - 1;

        boolean[][] seen = new boolean[n][1 << n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.add(new int[]{i, mask, 0});
            seen[i][mask] = true;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int mask = cur[1];
            int steps = cur[2];

            if (mask == allVisited) {
                return steps;
            }

            for (int neighbor : graph[node]) {
                int newMask = mask | (1 << neighbor);

                if (!seen[neighbor][newMask]) {
                    seen[neighbor][newMask] = true;
                    queue.add(new int[]{neighbor, newMask, steps + 1});
                }
            }
        }

        return 0;
    }
}