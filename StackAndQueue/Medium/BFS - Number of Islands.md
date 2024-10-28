[Number of Islands](https://leetcode.com/problems/number-of-islands/)

```java
class Solution {
    
    static int ROWS;
    static int COLS;
    
    static boolean visited[][];

    int[] dir_r = {-1,1,0,0};
    int[] dir_c = {0,0,-1,1};
    
    class Pair {
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    private boolean checkValidMove(char[][] grid, int r, int c){
        if(r>=0&&c>=0&&r<ROWS&&c<COLS&&(grid[r][c]=='1')&&!visited[r][c]) return true;
        return false;
    }
    
    public int numIslands(char[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;
        
        visited = new boolean[ROWS][COLS];
        for(boolean[] v : visited)
            Arrays.fill(v,false);
        
        
        LinkedList<Pair> queue = new LinkedList<Pair>();
        
        int count = 0;
        for(int r=0;r<ROWS;r++)
        {
            for(int c=0;c<COLS;c++)
            {
                if(grid[r][c]=='1' && visited[r][c]==false)
                {
                    count+=1;
                    visited[r][c]=true;
                    queue.add(new Pair(r,c));
                    while(queue.size()>0)
                    {
                        Pair tmp = queue.poll();
                        for(int d=0;d<dir_r.length;d++){
                            if(checkValidMove(grid, tmp.x+dir_r[d], tmp.y+dir_c[d])){
                                visited[tmp.x+dir_r[d]][tmp.y+dir_c[d]]=true;
                                queue.add(new Pair(tmp.x+dir_r[d],tmp.y+dir_c[d]));
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
```