https://leetcode.com/problems/koko-eating-bananas/description/

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;

        int min = 1; // min can eat per hour
        int max = 1; // max can eat per hour

        for (int i = 0; i < len; i++) {
            max = max > piles[i] ? max : piles[i];
        }

        int result = max;
        int mid;
        long hrsReq;
        while (min <= max) {

            mid = min + (max - min) / 2;

            hrsReq = calHours(piles, mid, len);

            if (hrsReq <= h) {
                // can be possible ans
                result = mid;

                // we can try further min
                max = mid-1;
            } else {

                // need to increase eat per hour
                min = mid + 1;
            }
        }

        return result;
    }

    private long calHours(int[] piles, int k, int len) {

        long hrsReq = 0; //overflow can happen

        //[805306368,805306368,805306368]
        // k = 1
        // int overflow will happen 
        for (int i = 0; i < len; i++) {

            // ceil we need to cal

            hrsReq += piles[i] / k;

            if (piles[i] % k != 0) {
                hrsReq += 1;
            }
        }
        return hrsReq;
    }
}
```

**Time Complexity:** $O( log(maxElement) * len)$

**Space Complexity:** $O(1)$