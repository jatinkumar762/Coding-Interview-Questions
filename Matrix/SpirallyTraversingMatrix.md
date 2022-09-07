[Problem](https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1)

```java
class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        int top=0, left=0;
        int bottom=r-1, right=c-1;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while(top<=bottom && left<=right){
            
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            
            for(int j=top;j<=bottom;j++){
                result.add(matrix[j][right]);
            }
            right--; 
            
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;
            
            if(left<=right){
                for(int j=bottom;j>=top;j--){
                    result.add(matrix[j][left]);
                }
            }
            left++;
            
        }
        
        return result;
    }
}
```