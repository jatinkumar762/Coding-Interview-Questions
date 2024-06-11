https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3

https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

```java
class Solution {
    List<Integer> kLargest(int[] arr, int size, int k) {
        // code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : arr){
            
            pq.add(n);
            
            if(pq.size()>k) pq.poll();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        Iterator<Integer> itr = pq.iterator();
        while(itr.hasNext()){
            result.add(itr.next());
        }
        
        return result;
    }
}
```