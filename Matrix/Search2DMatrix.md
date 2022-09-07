[Problem](https://leetcode.com/problems/search-a-2d-matrix/)

```java
class Solution {
    
    public boolean binarySearch(int[][] matrix, int target, int row, int start, int end){
        
        if(start>end)
            return false;
        
        int mid = (start+end)/2;
        
        if(matrix[row][start]==target || matrix[row][mid]==target || matrix[row][end]==target)
            return true;
        
        if(matrix[row][mid]>target)
            return binarySearch(matrix, target, row, start, mid-1);
        else
            return binarySearch(matrix, target, row, mid+1, end);
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        
        int i;
        for(i=0;i<=row;i++){
            if(matrix[i][col]>=target)
                break;
        }
        
        if(i>row)
            return false;
        
        return binarySearch(matrix, target, i, 0, col);
    }
}
```