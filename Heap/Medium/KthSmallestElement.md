https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

arr[] &rarr;  1 2 3 4 5 6 7 8 9 10

left to right &rarr; means &rarr; kth smallest

right to left &rarr; means &rarr; kth largest


### Approach-1 Using Priority Queue

* to find min, will create max heap of k size;

```java
class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        
        for(int ele : arr){
            
            pq.add(ele);
            
            count+=1;
            
            if(count > k){
                pq.poll();
                count = k;
            }
        }
        
        
        return pq.peek();
    }
}
```

### Approach-2 Using Quick Sort
