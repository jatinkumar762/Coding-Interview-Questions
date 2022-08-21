[Problem](https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1)

```java
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        LinkedList<Integer> result = new LinkedList<Integer>();
        result.add(1);
        
        for(int i=2;i<=N;i++){
            int j=0;
            int k=result.size();
            int carry=0;
            while(j<k){
                int tmp = result.poll();
                tmp = tmp*i + carry;
                result.add(tmp%10);
                carry = tmp/10;
                j++;
            }
            while(carry>0){
                result.add(carry%10);
                carry = carry/10;
            }
                
            System.out.println(result.size());
        }
        Collections.reverse(result);
        
        ArrayList<Integer> end = new ArrayList<Integer>();
        for(int i=0;i<result.size();i++){
            end.add(result.get(i));
        }
        return end;
    }
}
```

#### Time and Space Complexity

Time Complexity: O(n log n!)

* Complexity of multipy function is O(log n!). The ans array passed in represents n! . Also its length is ⌈log (n-1)!⌉(base 10). So the number of steps required will be ⌈log (n-1)!⌉(base 10)

* This can be understood as to calculate n! we have (n-1!) in the ans array and the number of digits in n-1! being ⌈log (n-1)!⌉ (base 10).

* For example,if (n-1)! is 1000, then the number of digits in it will be 4 and the number of steps required will be four.
And hence to calculate n! the complexity will be O(n log n!).

Space complexity: O(⌈log n!⌉)

* We can clearly see that we are storing the result in ans array . So at the end ans array stores n! also the number of digits or the length of array is ⌈log n!⌉ as discussed earlier. So the space complexity is O(⌈log n!⌉).

#### Editorial

* [https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/](https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/)
* [https://iq.opengenus.org/factorial-of-large-numbers/](https://iq.opengenus.org/factorial-of-large-numbers/)

