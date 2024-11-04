https://leetcode.com/problems/sum-of-subarray-ranges/description/

### Approach-1 Brute Force 19ms

```java
class Solution {
    public long subArrayRanges(int[] nums) {

        int len = nums.length;
        int largest, smallest;
        long sum = 0;

        for (int i = 0; i < len; i++) {
            
            largest = smallest = nums[i];
            
            for (int j = i + 1; j < len; j++) {
                
                largest = largest > nums[j] ? largest : nums[j];
                
                smallest = smallest < nums[j] ? smallest : nums[j];

                sum += largest - smallest;
            }
        }
        
        return sum;
    }
}
```

### Approach-2 &rarr; 28ms slower than first approach

* We can concept of [Sum of Sub-array Minimum Problem](./SumofSubarrayMinimums.md)
* Result &rarr; Sum(Sub-array Maximum) - Sum(Sub-array Minimum)

arr = [1, 2, 3]

1      &rarr; 1 - 1\
1 2    &rarr; 2 - 1\
1 2 3   &rarr; 3 - 1 

2     &rarr; 2 - 2 \
2 3   &rarr; 3 - 2

3     &rarr; 3 - 3

result &rarr; (1-1) + (2-1) + (3-1) + (2-2) + (3-2) + (3-3) &larr; Sum(Sub-array Maximum) - Sum(Sub-array Minimum)


```java
class Solution {
    public long subArrayRanges(int[] nums) {

        int N = nums.length;

        return sumSubarrayMaxs(nums, N) - sumSubarrayMins(nums, N);
    }

    private long sumSubarrayMins(int[] arr, int N) {

        int[] prevSmallIndex = new int[N];
        int[] nextSmallIndex = new int[N];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            int index = stack.isEmpty() ? -1 : stack.peek();

            prevSmallIndex[i] = index;

            stack.push(i);
        }

        stack = new Stack<Integer>();

        for (int i = N - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            int index = stack.isEmpty() ? N : stack.peek();

            nextSmallIndex[i] = index;

            stack.push(i);
        }
    
        long sum = 0L;

        for (int i = 0; i < N; i++) {
            sum += (long) (i - prevSmallIndex[i]) * (nextSmallIndex[i] - i) * arr[i];
        }

        return sum;
    }

    private long sumSubarrayMaxs(int[] arr, int N) {

        int[] prevMaxIndex = new int[N];
        int[] nextMaxIndex = new int[N];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            int index = stack.isEmpty() ? -1 : stack.peek();

            prevMaxIndex[i] = index;

            stack.push(i);
        }

        stack = new Stack<Integer>();

        for (int i = N - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int index = stack.isEmpty() ? N : stack.peek();

            nextMaxIndex[i] = index;

            stack.push(i);
        }

        long sum = 0L;

        for (int i = 0; i < N; i++) {
            sum += (long) (i - prevMaxIndex[i]) * (nextMaxIndex[i] - i) * arr[i];
        }

        System.out.println(sum);

        return sum;
    }
}
```

### Approach-3 4ms 

* Short of Approach-2 code

```java
class Solution {
    public long subArrayRanges(int[] nums) {

        long sum = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while(left > 0 && nums[left - 1] <= nums[i]) left--;
            while(right < n - 1 && nums[right + 1] < nums[i]) right++;
            
            sum += (long)(nums[i] * (long)(right - i + 1) * (long)(i - left + 1));
            
            left = i;
            right = i;
            while(left > 0 && nums[left - 1] >= nums[i]) left--;
            while(right < n - 1 &&nums [right + 1] > nums[i]) right++;
            
            sum -= (long)(nums[i] * (long)(right - i + 1) * (long)(i - left + 1));
        }
        
        return sum;
    }
}
```