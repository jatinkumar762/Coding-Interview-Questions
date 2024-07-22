https://leetcode.com/problems/letter-combinations-of-a-phone-number/

#### Approach-1 Recursive

```java
class Solution {

    String[] numToStr = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> result = new ArrayList<>();
    int N;

    private void findCombinations(int index, String digits, StringBuilder res) {

        if (index == N) {
            result.add(new String(res));
            return;
        }

        char ch = digits.charAt(index);
        String text = numToStr[ch - '0'];

        for (int i = 0; i < text.length(); i++) {
            res.append(text.charAt(i));
            findCombinations(index + 1, digits, res);
            res.deleteCharAt(res.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        N = digits.length();
        if (N != 0) {
            findCombinations(0, digits, new StringBuilder(""));
        }
        return result;
    }
}
```

#### Approach-2 -> ToDo: Iterative

https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/8064/my-java-solution-with-fifo-queue/