class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            if (check(nums, k)) sum += k;
        }
        return sum;
    }

    private boolean check(int[] a, int k) {
        int n = a.length;
        int prevMax = 0;

        for (int s = 0; s < n; s += k) {
            int e = s + k - 1;
            int descents = a[e] > a[s] ? 1 : 0;   // wrap-around
            int min = a[s], max = a[s];

            for (int i = s; i < e; i++) {
                if (a[i] > a[i + 1] && ++descents > 1) return false;
                min = Math.min(min, a[i + 1]);
                max = Math.max(max, a[i + 1]);
            }
            if (prevMax > min) return false;
            prevMax = max;
        }
        return true;
    }
}