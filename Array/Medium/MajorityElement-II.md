https://leetcode.com/problems/majority-element-ii/description/


#### Approach-1 Using Hashing

* TimeComplexity - $O(N)$
* SpaceComplexity - $O(N)$

#### Approach-2 Using Boyer-Moore Voting Algorithm

* TimeComplexity - $O(N)$
* SpaceComplexity - $O(1)$

* in problem asking, more than $⌊ n/3 ⌋$ times &rarr; max such elements can be possible in array are $2$
* suppose if n = 8, $⌊ n/3 ⌋$ = 2 &rarr; $( > 2)$ &rarr; (3 + 3 + 3) = 9 > 8 &rarr; so max 2 elements possible
* similarly, if n = 9, $⌊ n/3 ⌋$ = 3 &rarr; $( > 3)$ &rarr; (4 + 4 + 4) = 12 > 9 &rarr; so max 2 elements possible


#### test case - [2,1,1,3,1,4,5,6]

3ms Solution

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        int ele1 = -1, ele2 = -1;
        int count1 = 0, count2=0;
        
        for(int i=0;i<nums.length;i++){
            
            if (count1==0 && nums[i]!=ele2){
                ele1 = nums[i];
                count1=1;
            } else if (count2==0 && nums[i]!=ele1){
                ele2 = nums[i];
                count2=1;
            } else if(ele1==nums[i]){
                count1+=1;
            } else if (ele2==nums[i]){
                count2+=1;
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

**another way to write: 2ms Solution**

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        int ele1 = -1, ele2 = -1;
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
