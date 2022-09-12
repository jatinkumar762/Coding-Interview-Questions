[Majority Element](https://leetcode.com/problems/majority-element/)

#### Method-1: Brute Force
* Nested Loop

#### Method-2: HashMap

#### Method-3: Sorting
* If the elements are sorted in monotonically increasing (or decreasing) order, the majority element can be found at index floor(n/2) (,and also at floor(n/2)-1 if n is even)
* Will fail if there is no majority element

#### Method-4: Boyer-Moore Majority Voting Algorithm
* First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes.
* Otherwise, decrease the votes if votes become 0, select another new element as the new candidate.


```java
class Solution
{
    static int majorityElement(int nums[], int size)
    {
        // your code here
        int majorityElement = nums[0];
        int count = 1;
        
        for(int i=1;i<nums.length;i++){
            if(majorityElement==nums[i]){
                count++;
            } else {
                count--;
            }
            
            if(count==0){
               majorityElement = nums[i];
               count=1;
            }
        }
        count=0;
        for(int i=0;i<size;i++){
            if(nums[i]==majorityElement)
                count++;
            if(count>(size/2))
                return majorityElement;
        }
        return -1;
    }
}
```
---

[Majority Element II](https://leetcode.com/problems/majority-element-ii/)

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        int ele1 = -1;
        int ele2 = -1;
        int count1 = 0, count2=0;
        
        for(int i=0;i<nums.length;i++){
            
            if(ele1==nums[i]){
                count1+=1;
            } else if (ele2==nums[i]){
                count2+=1;
            } else if (count1==0){
                ele1 = nums[i];
                count1=1;
            } else if (count2==0){
                ele2 = nums[i];
                count2=1;
            } else {
                count1-=1;
                count2-=1;
            }
        }
        count1 = 0; count2=0;
        for(int num : nums){
            if(num==ele1){
                count1+=1;
            } else if(num==ele2){
                count2+=1;
            }
        }
        if(count1>(nums.length/3))
            result.add(ele1);
         if(count2>(nums.length/3))
            result.add(ele2);
        return result;
    }
}
```