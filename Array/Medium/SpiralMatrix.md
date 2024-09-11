https://leetcode.com/problems/spiral-matrix/description/

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // code here 
        int top=0, left=0;
        int bottom=matrix.length-1, right=matrix[0].length-1;
        
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