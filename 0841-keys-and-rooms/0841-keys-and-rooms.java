class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, 0, visited);

        for (boolean v : visited) {
            if (v == false) return false;
        }
        return true;
    }

    void visit(List<List<Integer>> rooms, int room, boolean[] visited) {
        if (visited[room]) return;

        visited[room] = true;

        for (int key : rooms.get(room)) {
            visit(rooms, key, visited);
        }
    }
}