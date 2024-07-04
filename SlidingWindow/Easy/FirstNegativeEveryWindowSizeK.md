1. https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
2. https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4

```java
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        List<Long> result = new ArrayList<>();
        
        Queue<Long> queue = new LinkedList<>();
        
        for(int i=0;i<K;i++){
            if(A[i]<0){
                queue.add(A[i]);
            }
        }
        
        if(queue.size()>0){
            result.add(queue.peek());
        } else {
            result.add(0L);
        }
        
        
        for(int i=K;i<N;i++){
            
            if(A[i]<0){
                queue.add(A[i]);
            }
            
            if(queue.size()>0 && queue.peek() == A[i-K]){
                queue.poll();
            }
            
            if(queue.size()>0){
                result.add(queue.peek());
            } else {
                result.add(0L);
            }
        }
        
        
        long[] finalResult = new long[result.size()];
        
        for(int i=0;i<result.size();i++){
            finalResult[i] = result.get(i);
        }
        
        return finalResult;
    }
}
```