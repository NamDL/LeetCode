public class TreasureIsland {
//    public static void main(String[] args) {
//        //12.32
//        char[][] grid = {{'O', 'O', 'O', 'O'},{'D', 'O', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};
//        int[][] dp= new int[grid.length][grid[0].length];
////        for(int i=0;i<grid.length;i++) {
////            for(int j=0;j<grid[0].length; j++) {
////                if(grid[i][j]=='X') dp[i][j]=0;
////                else dp[i][j]=Integer.MAX_VALUE;
////            }
////        }
//        int steps = Integer.MAX_VALUE;
//        steps = performDFS(grid, 0, 0, steps, -1, -1);
//        System.out.println(steps);
//    }
//
//    private static int performDFS(char[][] grid, int i, int j, int steps, int pi, int pj) {
//        //if(dp[i][j])
//        if(grid[i][j]=='X') {
////            steps = Math.min(steps, soFar);
////            return steps;
//            return 0;
//        }
//        grid[i][j]='D';
//        if(i>0 && (grid[i-1][j]=='O' || grid[i-1][j]=='X') && !(i-1==pi && j==pj)) {
//            steps = Math.min(steps, performDFS(grid, i-1, j, steps, i, j)+1);
//        }
//        if(j>0 && (grid[i][j-1]=='O' || grid[i][j-1]=='X') && !(i==pi && j-1==pj)) {
//            steps = Math.min(steps, performDFS(grid, i, j-1, steps, i, j)+1);
//        }
//        if(j<grid[i].length-1 && (grid[i][j+1]=='O' || grid[i][j+1]=='X') && !(i==pi && j+1==pj)) {
//            steps = Math.min(steps, performDFS(grid, i, j+1, steps,i, j)+1);
//        }
//        if(i<grid.length-1 && (grid[i+1][j]=='O' || grid[i+1][j]=='X') && !(i+1==pi && j==pj)) {
//            steps = Math.min(steps, performDFS(grid, i+1, j, steps, i, j)+1);
//        }
//        return steps;
//    }

    private int distance = Integer.MAX_VALUE;

    public int findShortestRoute(char[][] island) {
        if (island == null) {
            return -1;
        }
        boolean[][] visited = new boolean[island.length][island[0].length];
        dfs(island, 0, 0, visited, 0);

        return distance;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 'X') {
            distance = Math.min(distance, levelDistance);
            return;
        }
        visited[i][j] = true;

        dfs(grid, i, j - 1, visited, levelDistance + 1); // back
        dfs(grid, i - 1, j, visited, levelDistance + 1);// up
        dfs(grid, i, j + 1, visited, levelDistance + 1);// forward
        dfs(grid, i + 1, j, visited, levelDistance + 1);// downward

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        TreasureIsland obj = new TreasureIsland();
        char[][] input = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'X', 'O', 'O', 'O'},
                {'O', 'D', 'D', 'O'}};

        System.out.println(obj.findShortestRoute(input));

    }
}
