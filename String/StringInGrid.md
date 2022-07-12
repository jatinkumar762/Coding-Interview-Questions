[Problem](https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1#)

#### Case-1: Not in specific direction 
```java
class Solution
{
    int[] row = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] col = new int[]{-1,  0,  1, -1, 1, -1, 0, 1};
    
    int Rows;
    int Cols;
    public boolean findWord(char[][] grid, String word, int i, int j, int w){
        if(w>=word.length())
            return true;
            
        for(int r=0;r<row.length;r++){
            int R = i+row[r];
            int C = j+col[r];
            if(R>=0 && R<Rows && C>=0 && C<Cols)
            {
                if(grid[R][C]==word.charAt(w) && findWord(grid, word, R, C, w+1)){
                    //System.out.println(R+" "+C);
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int w=0;
        Rows = grid.length;
        Cols = grid[0].length;
        
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(w))
                {
                    if(findWord(grid, word, i, j, w+1)){
                        result.add(i+" "+j);
                    }
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = Integer.parseInt(result.get(i).split(" ")[0]);
            res[i][1] = Integer.parseInt(result.get(i).split(" ")[1]);
        }
        return res;
    }
}
```

#### Case-2: In specific direction 
```java
class Solution
{
    int[] row = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] col = new int[]{-1,  0,  1, -1, 1, -1, 0, 1};
    
    int Rows;
    int Cols;
    public boolean findWord(char[][] grid, String word, int i, int j, int w){
        
        if(w==word.length())
            return true;
                
        for(int dir=0;dir<row.length;dir++)
        {
            int R = i+row[dir];
            int C = j+col[dir];
            int k=0;
            for(k=1;k<word.length();k++)
            {
                if(R<0 || R>=Rows || C<0 || C>=Cols){
                  break;
                }
                if(grid[R][C]!=word.charAt(k)){
                  break;
                }
                R+=row[dir];
                C+=col[dir];
            }
            if(k==word.length())
                return true;
        }
        return false;
    }
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int w=0;
        Rows = grid.length;
        Cols = grid[0].length;
        
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(w))
                {
                    if(findWord(grid, word, i, j, w+1)){
                        result.add(i+" "+j);
                    }
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = Integer.parseInt(result.get(i).split(" ")[0]);
            res[i][1] = Integer.parseInt(result.get(i).split(" ")[1]);
        }
        return res;
    }
}
```