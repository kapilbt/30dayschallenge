class Solution {
    public int minMoves(int[] nums) {
        int smallest = nums[0];

        for (int x : nums) {
            if (x < smallest) {
                smallest = x;
            }
        }

        int moves = 0;

        for (int x : nums) {
            moves = moves + (x - smallest);
        }

        return moves;
    }
}