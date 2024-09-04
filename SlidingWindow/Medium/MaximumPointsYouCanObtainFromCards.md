https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

#### Wrong Approach

example - [1,2,3,4,5,6,1]
failed

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int start = 0, end = len - 1;
        int sum = 0;

        while (start <= end && k > 0) {
            k--;
            if (cardPoints[start] >= cardPoints[end]) {
                sum += cardPoints[start];
                start++;
            } else {
                sum += cardPoints[end];
                end--;
            }
        }

        return sum;
    }
}
```

---

#### Sliding Window $3ms$

* Let the sum of all points be total_pts. You need to remove a sub-array from cardPoints with length n - k.
* Keep a window of size n - k over the array. The answer is max(answer, total_pts - sumOfCurrentWindow)


```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int cardPointsSum = 0;
        int maxSum = 0;

        for (int i = 0; i < len; i++) {
            cardPointsSum += cardPoints[i];
        }

        if (len == k) {
            return cardPointsSum;
        }

        int windowSize = len - k;
        int left = 0, right = 0;
        int windowSum = 0;

        for (; right < len; right++) {
            windowSum += cardPoints[right];

            if ((right - left + 1) == windowSize) {
                maxSum = Math.max(maxSum, cardPointsSum - windowSum);
                windowSum -= cardPoints[left++];
            }
        }

        return maxSum;
    }
}
```

**more optimization** $2ms$

```java

class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int cardPointsSum = 0;
        int maxSum = 0;

        for (int i = 0; i < len; i++) {
            cardPointsSum += cardPoints[i];
        }

        if (len == k) {
            return cardPointsSum;
        }

        int windowSize = len - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        maxSum = Math.max(maxSum, cardPointsSum - windowSum);

        int left = 0, right = windowSize;

        for (; right < len; right++) {
            windowSum -= cardPoints[left++];
            windowSum += cardPoints[right];

            maxSum = Math.max(maxSum, cardPointsSum - windowSum);
        }

        return maxSum;
    }
}
```