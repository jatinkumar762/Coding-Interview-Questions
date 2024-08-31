https://leetcode.com/problems/fruit-into-baskets/description/

#### Approach-1 2 pointers

* this approach will work for max bucket k
* here k=2

//Input: 2 1 3 2
//Output: 2

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

**little optimization**

```java
class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();
        int N = fruits.length;
        int max = 0, start = 0;

        for (int end = 0; end < N; end++) {

            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

            if (basket.size() > 2) {

                if (basket.get(fruits[start]) <= 1) {
                    basket.remove(fruits[start]);
                } else {
                    basket.put(fruits[start], basket.get(fruits[start]) - 1);
                }

                start++;
            } else {
                max = Math.max(max, end - start + 1);
            }
        }

        return max;
    }
}
```

#### Approach-2 Using two   

&rarr; ToDo - https://leetcode.com/problems/fruit-into-baskets/solutions/170745/problem-longest-subarray-with-2-elements/

```java
class Solution {
    public int totalFruit(int[] tree) {
        // track last two fruits seen
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;
        
        for (int fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1; // last fruit + new fruit
            
            if (fruit == lastFruit)
                lastFruitCount++;
            else
                lastFruitCount = 1; 
            
            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}
```