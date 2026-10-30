import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(e);

        int[][] best = new int[n][k + 1];
        for (int[] r : best) Arrays.fill(r, Integer.MAX_VALUE);
        best[0][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 1}); 

        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int cost = t[0], node = t[1], count = t[2];
            if (cost > best[node][count]) continue;
            if (node == n - 1) return cost;

            for (int[] e : g[node]) {
                int next = e[1];
                int c = labels.charAt(next) == labels.charAt(node) ? count + 1 : 1;
                if (c > k || cost + e[2] >= best[next][c]) continue;
                best[next][c] = cost + e[2];
                pq.add(new int[]{best[next][c], next, c});
            }
        }
        return -1;
    }
}