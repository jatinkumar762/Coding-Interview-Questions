https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

### Linear Search

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if (m * k > n) {
            // each bucket consists of k flowers
            // each flower can be part of 1 bouquet
            return -1;
        }

        int maxDays = bloomDay[0];
        int minDays = bloomDay[0];
        for (int i = 1; i < n; i++) {
            maxDays = maxDays > bloomDay[i] ? maxDays : bloomDay[i];
            minDays = minDays < bloomDay[i] ? minDays : bloomDay[i];
        }

        for (int d = minDays; d <= maxDays; d++) {
            if (isBouquetsPossible(bloomDay, m, k, d, n)) {
                return d;
            }
        }

        return -1;
    }

    private boolean isBouquetsPossible(int[] bloomDay, int m, int k, int days, int n) {

        int i, j;
        for (i = 0; i < n;) {

            for (j = 0; (i + j) < n && j < k; j++) {
                if (bloomDay[i + j] <= days) {
                    continue;
                }
                break;
            }

            if (j == k) {
                m -= 1;
                i += k;
            } else {
                i += (j + 1);
            }

            if (m == 0) {
                break;
            }
        }

        return m == 0;
    }
}
```

### Binary Search 

* above linear search can be converted into binary search

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if (m * k > n) {
            // each bucket consists of k flowers
            // each flower can be part of 1 bouquet
            return -1;
        }

        int maxDays = bloomDay[0];
        int minDays = bloomDay[0];
        for (int i = 1; i < n; i++) {
            maxDays = maxDays > bloomDay[i] ? maxDays : bloomDay[i];
            minDays = minDays < bloomDay[i] ? minDays : bloomDay[i];
        }

        int res = -1;
        while (minDays <= maxDays) {

            int mid = minDays + (maxDays - minDays) / 2;

            if (isBouquetsPossible(bloomDay, m, k, mid, n)) {
                res = mid; // can be possible answer
                maxDays = mid - 1; // will try to go for min. days
            } else {
                minDays = mid + 1;
            }
        }

        return res;
    }

    private boolean isBouquetsPossible(int[] bloomDay, int m, int k, int days, int n) {

        int i, j;
        for (i = 0; i < n;) {

            for (j = 0; (i + j) < n && j < k; j++) {
                if (bloomDay[i + j] <= days) {
                    continue;
                }
                break;
            }

            if (j == k) {
                m -= 1;
                i += k;
            } else {
                i += (j + 1);
            }

            if (m == 0) {
                break;
            }
        }

        return m == 0;
    }
}
```