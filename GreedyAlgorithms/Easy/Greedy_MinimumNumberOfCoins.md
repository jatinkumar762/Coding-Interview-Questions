https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.

* each denomination of Indian currency given, so we can easily use greedy approach, otherwise greedy will not work
* suppose coins are {4, 3} and sum = 6, in this case greedy will not work
* here, each indian currency given, we can use greedy

```java
class Solution{
    
    static List<Integer> minPartition(int N)
    {
        List<Integer> result = new ArrayList<Integer>();
        // code here
        int[] currency = new int[]{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        
        int index = currency.length-1;
        
        while(N>0 && index>=0){
            while(N>=currency[index]){
                N-=currency[index];
                result.add(currency[index]);
            }
            index-=1;
        }
        
        return result;
    }
}
```

#### if they asked count of coins

count += N/currency[index]
N = N%currency[index]

