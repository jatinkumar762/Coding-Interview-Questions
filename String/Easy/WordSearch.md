[GFG](https://practice.geeksforgeeks.org/problems/word-search/1)

```java
class Solution
{
    int[] r_d = {-1,1,0,0};
    int[] c_d = {0,0,-1,1};
    
    int R;
    int C;
    
    boolean[][] visited;
    
    public boolean validMove(int row,int col, char ch, char[][] board){
        if(row>=0&&row<R&&col>=0&&col<C&&(!visited[row][col])&&board[row][col]==ch)
            return true;
        return false;
    }
    
    public boolean internalSearch(char[][] board, String word, int row, int col, int start){
        
        if(start==word.length())
            return true;
        char ch = word.charAt(start);
        
        for(int i=0;i<r_d.length;i++){
            if(validMove(row+r_d[i], col+c_d[i], ch, board)){
                visited[row+r_d[i]][col+c_d[i]]=true;
                if(internalSearch(board, word, row+r_d[i], col+c_d[i], start+1))
                    return true;
                visited[row+r_d[i]][col+c_d[i]]=false;
            }
        }
        return false;
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        
        R = board.length;
        C = board[0].length;
        
        visited = new boolean[R][C];
        
        for(boolean[] v:visited)
            Arrays.fill(v,false);
        
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(board[r][c]==word.charAt(0)){
                    visited[r][c]=true;
                    if(internalSearch(board, word, r, c, 1))
                        return true;
                    visited[r][c]=false;
                }
            }
        }
        return false;
    }
}
```

#### Related Problems
* [Search a Word in a 2D Grid of characters](https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/)
* [Count of number of given string in 2D character array](https://www.geeksforgeeks.org/find-count-number-given-string-present-2d-character-array/)