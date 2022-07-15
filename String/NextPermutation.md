[Problem](https://leetcode.com/problems/next-permutation/)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length>1)
        {
            int i,j;
            for(i=nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1])
                    break;
            }
            if(i<0){
                Arrays.sort(nums);
            }
            else{
                
                int maxIndex = i+1;
                for(j=i+1;j<nums.length;j++){
                    if(nums[j]>nums[i] && nums[j]<=nums[maxIndex]){
                        maxIndex=j;
                    }
                }
                
                int tmp = nums[maxIndex];
                nums[maxIndex] = nums[i];
                nums[i] = tmp;
                
                //Arrays.sort(nums, i+1, nums.length);
                 int k=i+1;
                 int l=nums.length-1;
                 while(k<l){
                     tmp = nums[k];
                     nums[k] = nums[l];
                     nums[l] = tmp;
                     k++;l--;
                 }

            }
        }
        for(Integer ele : nums){
            result.add(ele);
        }
        System.out.println(result);
    }
}
```