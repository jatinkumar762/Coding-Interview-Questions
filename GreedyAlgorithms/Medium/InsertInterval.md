https://leetcode.com/problems/insert-interval/description/

```java
class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int N = intervals.length;

        int start = newInterval[0];
        int end = newInterval[1];

        int index = 0;
        // which are lesser
        for (; index < N; index++) {
            if (start > intervals[index][1]) {
                result.add(new int[] { intervals[index][0], intervals[index][1] });
            } else {
                break;
            }
        }

        // overlapping
        while (index < N && start <= intervals[index][1] && (end >= intervals[index][1]
                || end >= intervals[index][0])) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        result.add(new int[] { start, end });

        // remaining which are greater
        for (; index < N; index++) {
            result.add(new int[] { intervals[index][0], intervals[index][1] });
        }

        int resultSize = result.size();
        int[][] finalRes = new int[resultSize][2];

        for (int i = 0; i < resultSize; i++) {
            finalRes[i][0] = result.get(i)[0];
            finalRes[i][1] = result.get(i)[1];
        }

        return finalRes;
    }
}
```