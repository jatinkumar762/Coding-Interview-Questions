https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

```java
class Solve {
    
    int[] findTwoElement(int arr[], int n) {
        // code here
        int i;
        int[] res = new int[2];
        
        for (i = 0; i < n; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                res[0] = abs_val;
        }
    
        for (i = 0; i < n; i++) {
            if (arr[i] > 0)
                res[1] = i+1;
        }
        
        return res;
    }
}
```