class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            if (isSelfDividing(n)) result.add(n);
        }
        return result;
    }

    private boolean isSelfDividing(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            int d = c - '0';
            if (d == 0 || n % d != 0) return false;
        }
        return true;
    }
}