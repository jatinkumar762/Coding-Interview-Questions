https://leetcode.com/problems/merge-intervals/description/



```java
class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval i) {
        return Integer.compare(start, i.start);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        int N = intervals.length;

        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList);

        for (int i = 0; i < N;) {
            int start = intervalList.get(i).start;
            int end = intervalList.get(i).end;

            int j;
            for (j = i + 1; j < N; j++) {
                if (intervalList.get(j).start <= end) {
                    end = Math.max(end, intervalList.get(j).end);
                } else {
                    break;
                }
            }

            result.add(new int[] { start, end });

            i = j;
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

**Another way to write code - Slow bcz of getLast**

```java
class Solution {
    public int[][] merge(int[][] intervals) {

        LinkedList<int[]> result = new LinkedList<>();
        int N = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {

            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
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