https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

#### In-Place Approach - Optimal 

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

#### Using Visited Array

* Create a temp array visited[] of size n+1 with all initial values as false. Note that array values go upto n, that is why we have taken size as n+1.
* Traverse the input array arr[], and do the following for each arr[i]
    * if(visited[arr[i]] == false), set visited[arr[i]) = true;
    * if(visited[arr[i]] == true) output “arr[i]” //repeating number
* Traverse visited[] and output ‘i’ corresponding to the element of array visited[] having value as false. (This is the missing number)