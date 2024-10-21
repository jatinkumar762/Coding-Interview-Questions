https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int minCapacity = 1;
        int maxCapacity = 0;

        // if days = 1
        for (int w : weights) {
            maxCapacity += w;
        }

        if (days == 1) {
            return maxCapacity;
        }

        int midCapacity, res = 0, shipDays;
        while (minCapacity <= maxCapacity) {

            midCapacity = minCapacity + (maxCapacity - minCapacity) / 2;

            shipDays = shipTransmitDays(weights, midCapacity);

            if (shipDays <= days) {
                res = midCapacity; // possible ans for ship capacity
                maxCapacity = midCapacity - 1; // more less capacity will try
            } else {
                minCapacity = midCapacity + 1;
            }

        }
        return res;
    }

    private int shipTransmitDays(int[] weights, int capacity) {

        int days = 0;
        int sum = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                return Integer.MAX_VALUE;
            }

            sum += weight;

            if (sum == capacity) {
                sum = 0;
                days += 1;
            } else if (sum > capacity) {
                sum = weight;
                days += 1;
            }
        }

        if (sum > 0) {
            days += 1;
        }

        return days;
    }
}
```