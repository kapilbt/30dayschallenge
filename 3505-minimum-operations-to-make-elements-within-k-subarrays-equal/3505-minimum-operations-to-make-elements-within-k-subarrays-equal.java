class Solution {
    int m; int[] c; long[] s, v;

    void add(int r, int d) {
        long val = v[r - 1];
        for (; r <= m; r += r & -r) { c[r] += d; s[r] += d * val; }
    }

    public long minOperations(int[] a, int x, int k) {
        int n = a.length;
        long[] t = new long[n];
        for (int i = 0; i < n; i++) t[i] = a[i];
        java.util.Arrays.sort(t);
        m = 0;
        for (int i = 0; i < n; i++) if (i == 0 || t[i] != t[i - 1]) t[m++] = t[i];
        v = java.util.Arrays.copyOf(t, m);
        c = new int[m + 1]; s = new long[m + 1];
        int[] rk = new int[n];
        for (int i = 0; i < n; i++) rk[i] = java.util.Arrays.binarySearch(v, a[i]) + 1;

        long[] cost = new long[n - x + 1];
        long tot = 0;
        int top = Integer.highestOneBit(m);
        for (int i = 0; i < n; i++) {
            add(rk[i], 1); tot += a[i];
            if (i >= x) { add(rk[i - x], -1); tot -= a[i - x]; }
            if (i >= x - 1) {
                int p = 0, need = (x + 1) / 2;
                for (int pw = top; pw > 0; pw >>= 1)
                    if (p + pw <= m && c[p + pw] < need) { p += pw; need -= c[p]; }
                int r = p + 1, cl = 0; long sl = 0, med = v[p];
                for (int q = r; q > 0; q -= q & -q) { cl += c[q]; sl += s[q]; }
                cost[i - x + 1] = med * cl - sl + (tot - sl) - med * (x - cl);
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1], cur = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            cur[0] = INF;
            for (int i = 1; i <= n; i++) {
                long b = cur[i - 1];
                if (i >= x && prev[i - x] < INF) b = Math.min(b, prev[i - x] + cost[i - x]);
                cur[i] = b;
            }
            long[] sw = prev; prev = cur; cur = sw;
        }
        return prev[n];
    }
}