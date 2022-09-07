[Problem](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1)

```java
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int leftMost_one_colIndex = m-1;
        int row=-1;
        
        for(int i=0;i<n;i++){
            if(arr[i][leftMost_one_colIndex]==0)
                continue;
            
            while(leftMost_one_colIndex>=0 && arr[i][leftMost_one_colIndex]!=0){
               leftMost_one_colIndex--; 
            }
            row=i;
            if(leftMost_one_colIndex<0)
                break;
        }
        
        return row;
    }
}
```