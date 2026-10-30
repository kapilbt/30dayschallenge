class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            if (++count[c] % 2 == 0) len += 2;
        }
        return len < s.length() ? len + 1 : len;
    }
} 