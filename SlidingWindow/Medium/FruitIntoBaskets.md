https://leetcode.com/problems/fruit-into-baskets/description/

#### Approach-1 2 pointers

* this approach will work for max bucket k
* here k=2

```java
class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> basket = new HashMap<>();
        int N = fruits.length;
        int max = 0, start=0;
        
        for(int end=0; end<N; end++){
            
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0)+1);
            
            while(basket.size()>2){
                
                basket.put(fruits[start], basket.get(fruits[start])-1);
                
                if(basket.get(fruits[start])==0){
                    basket.remove(fruits[start]);
                }
                
                start++;
            }
            
            max = Math.max(max, end-start+1);
        }
        
        
        return max;
    }
}
```
