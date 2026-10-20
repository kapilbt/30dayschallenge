class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) go(digits, 0, "");
        return res;
    }

    void go(String d, int i, String cur) {
        if (i == d.length()) { res.add(cur); return; }
        for (char c : map[d.charAt(i) - '0'].toCharArray())
            go(d, i + 1, cur + c);
    }
}