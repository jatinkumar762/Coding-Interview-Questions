https://leetcode.com/problems/find-k-closest-elements/description/
https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5

Note -> if given array is already sorted


*** if given array is not sorted

#### Approach-1 Sorting

#### Approach-2 Max Heap

```java
class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // Define a custom comparator for Pair objects
        Comparator<Pair<Integer, Integer>> pairComparator = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                // Compare based on the keys (integer values)
                // p2 is new coming/adding in heap
                //p1 is existing number in heap
                int diff = Integer.compare(p1.getKey(), p2.getKey());

                if(diff!=0)
                    return -1 * diff;

                return -1* Integer.compare(p1.getValue(), p2.getValue());
            }
        };

        List<Integer> result = new ArrayList<Integer>();

        //build max heap -> max elment will have higher priority
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(pairComparator);

        int count = 0;
        for(int ele:arr){
            count++;
            priorityQueue.add(new Pair(Math.abs(ele-x), ele));

            if(count>k){
                priorityQueue.poll();
                count--;
            }
        }

        while(k>0){
            result.add(priorityQueue.poll().getValue());
            k--;
        }

        Collections.sort(result);

        return result;
    }
}
```