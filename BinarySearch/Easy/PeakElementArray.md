[Problem](https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/)

#### Approach-1 (Linear Traversal)
* Run a single loop and check for each element

#### Approach-2 (Binary Search)
* Important is to consider boundary check

```java
 if ((mid == 0 || arr[mid - 1] <= arr[mid])&& (mid == n - 1 || arr[mid + 1] <= arr[mid])) 
  break;
```