class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder currState = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                currState.append(board[i][j]);
            }
        }

        String targetState = "123450";
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(currState.toString());
        visited.add(currState.toString());

        int[][] dirs = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
        };

        int levels = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String state = queue.poll();
                if (state.equals(targetState)) {
                    return levels;
                }

                int zeroPos = state.indexOf('0');
                for (int dir : dirs[zeroPos]) {
                    StringBuilder newState = new StringBuilder(state);
                    newState.setCharAt(zeroPos, state.charAt(dir));
                    newState.setCharAt(dir, '0');
                    if (!visited.contains(newState.toString())) {
                        visited.add(newState.toString());
                        queue.add(newState.toString());
                    }
                }
            }
            levels++;
        }
        return -1;
    }
}