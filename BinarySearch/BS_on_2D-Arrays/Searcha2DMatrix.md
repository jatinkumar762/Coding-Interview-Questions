https://leetcode.com/problems/search-a-2d-matrix/description/

### Approach-1 Using Binary Search - 0ms

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
        int midIndex, midElement;

        while (left <= right) {

            midIndex = left + (right - left) / 2;
            
            // Convert mid to row and column
            midElement = matrix[midIndex / cols][midIndex % cols];

            if (midElement == target) {
                return true;
            }

            if (midElement > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }

        }

        return false;
    }
}
```

**Another way to write** 1ms

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