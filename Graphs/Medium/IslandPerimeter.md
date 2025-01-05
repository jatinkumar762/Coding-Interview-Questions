https://leetcode.com/problems/island-perimeter/description/


Note - this is not fastest solution

#### Approach-1 Using DFS 

```java
class Solution {
    int Rows;
    int Cols;
    public int islandPerimeter(int[][] grid) {
        
        Rows = grid.length;
        Cols = grid[0].length;
        for(int i=0;i<Rows;i++){
            for(int j=0;j<Cols;j++){
                if(grid[i][j]==1){
                    return getPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int getPerimeter(int[][] grid, int R, int C){
        
        //boundary land
        if (R < 0 || R >= Rows || C < 0 || C >= Cols) {
            return 1;
        }

        //water exist
        //will contribute 1 for land
        if(grid[R][C]==0){
            return 1;
        }

        //already visited
        if(grid[R][C]==-1){
            return 0;
        }
        
        int count = 0;

        //mark visited
        grid[R][C] = -1;

        //given Grid cells are connected horizontally/vertically (not diagonally)
        count += getPerimeter(grid, R-1, C);
        count += getPerimeter(grid, R+1, C);
        count += getPerimeter(grid, R, C+1);
        count += getPerimeter(grid, R, C-1);

        return count;
    }
}
```