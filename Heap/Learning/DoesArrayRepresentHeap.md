https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1

### Iterative Approach

```java
class Solution {
    
    public boolean countSub(long arr[], long n)
    {
        // Your code goes here
        
        long leftChild = 0L, rightChild = 0L, i = 0L;
        
        for(; i <= (n - 1)/2; i++){
            
            leftChild = 2 * i + 1L;
            rightChild = 2 * i + 2L;
            
            if(leftChild < n && arr[(int)i] < arr[(int)leftChild]){
                return false;
            }
            
            if(rightChild < n && arr[(int)i] < arr[(int)rightChild]){
                return false;
            }
        }
        
        return true;
    }
}
```

### Recursive Approach

```java
// Returns true if arr[i..n-1]  
// represents a max-heap 
static boolean isHeap(int arr[],  
                      int i, int n) 
{ 
    // If (2 * i) + 1 >= n, then leaf node, so return true 
    if (i >= (n - 1) / 2)  
    { 
        return true; 
    } 

    // If an internal node and  
    // is greater than its 
    // children, and same is  
    // recursively true for the 
    // children 
    if (arr[i] >= arr[2 * i + 1] 
        && arr[i] >= arr[2 * i + 2] 
        && isHeap(arr, 2 * i + 1, n) 
        && isHeap(arr, 2 * i + 2, n))  
    { 
        return true; 
    } 

    return false; 
}
```