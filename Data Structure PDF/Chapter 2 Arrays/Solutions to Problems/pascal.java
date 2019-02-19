int[][] pascal(int n) {
    int[][] p = new int[n][n];
    
    for (int j = 0; j < n; j++) {
        p[j][0] = p[j][j] = 1;
    }
    
    for (int i = 2; i < n; i++) {
        for (int j = 1; j < i; j++) {
            p[i][j] = p[i-1][j-1] + p[i-1][j];
        }
    }
    return p;
}