1. https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
2. https://leetcode.com/problems/sliding-window-maximum/description/
3. https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6

```java
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && queue.peekLast()<arr[i]){
                queue.pollLast();
            }
            queue.add(arr[i]);
        }
        
        result.add(queue.peek());
        
        for(int i=k;i<arr.length;i++) {
            
            //very imp step
            if(queue.peek()==arr[i-k]) {
                    queue.poll();
            }
                    
            while(!queue.isEmpty() && queue.peekLast()<arr[i]){
                queue.pollLast();
            }
            queue.add(arr[i]);

            result.add(queue.peek());
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
```