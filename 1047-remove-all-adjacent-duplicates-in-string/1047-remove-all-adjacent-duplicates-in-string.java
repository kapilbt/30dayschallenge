class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int last = sb.length() - 1;
            if (last >= 0 && sb.charAt(last) == c) {
                sb.deleteCharAt(last);   // adjacent duplicate, remove it
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}