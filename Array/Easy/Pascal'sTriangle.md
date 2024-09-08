https://leetcode.com/problems/pascals-triangle/description/

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    tmp.add(1);
                } else {
                    // if i =3
                    // res has index start from 0
                    // previous i=2 will be on 1 index in res
                    tmp.add(result.get(i - 2).get(j) + result.get(i - 2).get(j - 1));
                }
            }
            System.out.println(Arrays.toString(tmp.toArray()));
            result.add(tmp);
        }

        return result;
    }
}
```