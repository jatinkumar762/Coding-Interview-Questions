[01 Matrix](https://leetcode.com/problems/01-matrix/)

#### Method-1: BFS

```java
class Solution {
    
    class Position{
        int r;
        int c;
        Position(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    int[] row_dir = {1, -1, 0, 0};
    int[] col_dir = {0, 0, -1, 1};
    int tot_dir = 4;
    int ROWS;
    int COLS;
    
    private boolean isSafe(int row,int col){
        if(row>=0&&row<ROWS&&col>=0&&col<COLS){
            return true;
        }
        return false;
    }
    
    public int[][] updateMatrix(int[][] mat) {
        ROWS = mat.length;
        COLS = mat[0].length;
        
        int[][] dist = new int[ROWS][COLS];
        LinkedList<Position> queue = new LinkedList<Position>(); 
        
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(mat[r][c]==0){
                    dist[r][c] = 0;
                    queue.add(new Position(r,c));
                } else {
                    dist[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(queue.size()>0){
            Position curr = queue.poll();      
            for(int i=0;i<tot_dir;i++){
                int new_row = curr.r+row_dir[i];
                int new_col = curr.c+col_dir[i];
                if(isSafe(new_row, new_col)){
                    if(dist[new_row][new_col]>(dist[curr.r][curr.c]+1)){
                        dist[new_row][new_col] = dist[curr.r][curr.c]+1;
                        queue.add(new Position(new_row,new_col));
                    }
                }
            }
        }
        return dist;
    }
}
```

###### Complexity Analysis

* Time complexity: O(r⋅c)
  * Since, the new cells are added to the queue only if their current distance is greater than the calculated distance, cells are not likely to be added multiple times.

* Space complexity: O(r⋅c)
  * An additional O(r \cdot c)O(r⋅c) space is required to maintain the queue