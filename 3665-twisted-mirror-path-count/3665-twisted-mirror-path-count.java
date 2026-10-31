class Solution {
    public int uniquePaths(int[][] grid) {
        final int M = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        int[] D = new int[n];
        for (int i = 0; i < m; i++) {
            int r = 0;
            for (int j = 0; j < n; j++) {
                int d = D[j], nr;
                if (i == 0 && j == 0) { nr = 1; D[0] = 1; }
                else {
                    if (i == m - 1 && j == n - 1) return (r + d) % M;
                    if (grid[i][j] == 0) { nr = (r + d) % M; D[j] = nr; }
                    else { nr = d; D[j] = r; }
                }
                r = nr;
            }
        }
        return 1;
    }
}