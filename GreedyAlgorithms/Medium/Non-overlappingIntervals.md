https://leetcode.com/problems/non-overlapping-intervals/description/

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int N = intervals.length;

        // List<Interval> intervalList = new ArrayList<>();
        // for (int i = 0; i < N; i++) {
        //     intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        // }

        // Collections.sort(intervalList);

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int remove = 0;
        int end = intervals[0][1];
        for (int i = 1; i < N; i++) {
            // check overlap
            if (intervals[i][0] < end) {
                remove += 1;
            } else {
                end = intervals[i][1];
            }
        }

        return remove;
    }
}
```