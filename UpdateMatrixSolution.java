class UpdateMatrixSolution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length, level = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// U D L R
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = level + 1;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}