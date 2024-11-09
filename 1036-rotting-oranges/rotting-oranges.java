class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited = grid;
        int m = grid.length;
        int n = grid[0].length;
        int[][] d = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int answer= 0;
        Queue<int[]> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i=0; i<m;i++)
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1)
                    cntFresh++;
                if(grid[i][j]==2) {
                    q.offer(new int[]{i,j});
                }
            }
        
        while(!q.isEmpty()) {
            int curQueueSize = q.size();
            while(curQueueSize > 0) {
                int[] poll = q.poll();
                curQueueSize--;
                for(int i=0;i<4;i++) {
                    int[] next = new int[]{poll[0]+d[i][0], poll[1]+d[i][1]};
                    int r = next[0];
                    int c = next[1];
                    if(r>=0 && r<m && c>=0 && c<n && visited[r][c]==1) {
                        visited[r][c]=2;
                        cntFresh--;
                        q.offer(next);
                    }
                }
            }
  
            if(q.size()==0)
                break;
            answer++;
        }
        if(cntFresh==0) 
            return answer;
        
        return -1;
    }
}