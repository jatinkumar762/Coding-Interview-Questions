https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

### Approach-1 Using Priority Queue (Min Heap)

```java
class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int count = 0, K;

    public KthLargest(int k, int[] nums) {
        K = k;

        for (int num : nums) {
            pq.add(num);

            count += 1;

            if (count > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {

        pq.add(val);

        count += 1;

        if (count > K) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```