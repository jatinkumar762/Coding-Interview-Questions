https://leetcode.com/problems/count-number-of-nice-subarrays/description/

## Sliding Window (10 ms)

* similar to problem - https://leetcode.com/problems/binary-subarrays-with-sum/description/

```java
class Solution {

    private int countNiceSubArray(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }
        int left = 0, right = 0;
        int count = 0, odd = 0;
        int n = nums.length;

        for (; right < n; right++) {

            if ((nums[right] & 1) == 1) {
                odd++;
            }

            while (odd > k) {
                if ((nums[left] & 1) == 1) {
                    odd--;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return countNiceSubArray(nums, k) - countNiceSubArray(nums, k - 1);
    }
}
```

**Time Complexity: $2*O(N+N)$**

---

## Sliding Window Approach - 2 (6 ms)

* https://www.youtube.com/watch?v=4zNK0rhFfcA

nums = [2, 2, 1, 1, 2, 1, 1]

k = 3

[1 1 2 1] &rarr; index 2 - 5

we can include in result sub arrays

[2, 1, 1, 2, 1] &rarr; index 1 - 5
[2, 2, 1, 1, 2, 1] &rarr; index 0 - 5


```java
class Solution {

    //nums = [2, 2, 1, 1, 2, 1, 1], k=3
    public int numberOfSubarrays(int[] nums, int k) {

        int left = 0, right = 0, mid=0;
        int count = 0, odd = 0;
        int n = nums.length;

        for (; right < n; right++) {

            if ((nums[right] & 1) == 1) {
                odd++;
            }

            while (odd > k) {
                if ((nums[left] & 1) == 1) {
                    odd--;
                }
                left++;
            }

            if (odd == k) {
                
                mid = left;
                
                //even number
                while((nums[mid] & 1) == 0){
                    mid++;
                }
                
                //mid-left will also include in count
                // 1 -> bcz of current found
                count +=  1 + mid-left;
            }
        }

        return count;
    }
}
```
---

## Single pass solution

https://leetcode.com/problems/count-number-of-nice-subarrays/solutions/419378/java-c-python-sliding-window-o-1-space/

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int res = 0, left = 0, count = 0, n = nums.length;
        
        /*
            [2,1,2,1,1] k = 2
            
            [2, 1, 2, 1]
            [1, 2, 1]
        */
        for (int right = 0; right < n; right++) {

            if (nums[right] % 2 == 1) {
                --k;
                count = 0;
            }

            while (k == 0) {
                k += nums[left++] & 1;
                ++count;
            }

            res += count;
        }

        return res;
    }
}
```
