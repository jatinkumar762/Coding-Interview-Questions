https://leetcode.com/problems/kth-largest-element-in-an-array/description/

#### Approach-1 Sorting


#### Approach-2 Min Heap

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        /*
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){

                if(num1<num2) {
                    return 1;
                }
                else if(num1>num2) {
                    return -1;
                }
                return 0;
            }
        };

        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
        */

        //default is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:nums){
            pq.add(num);

            if(pq.size()>k) pq.poll();
        }


        return pq.peek();
    }
}
```

#### Approach-3 Selection Sort