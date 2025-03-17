https://leetcode.com/problems/longest-substring-without-repeating-characters/description/


### Approach-1 Using Freq and sliding window concept

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[128];

        char[] charArr = s.toCharArray();

        int length = s.length();

        int left = 0, right = 0, max = 0, count = 0;

        for (; right < length;) {

            if (freq[charArr[right] - 1] == 0) {

                freq[charArr[right] - 1]++;
                count++;
                right++;

            } else {

                while (left < right && freq[charArr[right] - 1] > 0) {
                    freq[charArr[left] - 1]--;

                    if (freq[charArr[left] - 1] == 0) {
                        count--;
                    }

                    left++;
                }

            }

            max = Math.max(max, count);
        }

        return Math.max(max, count);
    }
}
```

#### Approach-2 Using HashMap

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r, 0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}
```

**Optimization:**

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        //map will store char position in string

        int start = 0, end = 0, max = 0;
        
        int len = s.length();

        char[] charArr = s.toCharArray();

        for (; end < len; end++) {

            if (map.containsKey(charArr[end])) {
                /*
                will cause more time complexity
                int index = map.get(charArr[end]);
                for (; start <= index; start++) {
                    map.remove(charArr[start]);
                }
                */
                //"abba"
                start = Math.max(start, map.get(charArr[end])+1);
                //start should not go back
                //we can't do start = map.get(charArr[end])+1
            }
            map.put(charArr[end], end);
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
```

#### Approach-3 Using Hashing

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] charToIndex = new int[128];
        //s consists of English letters, digits, symbols and spaces. - 128
        //see ascii characters
        Arrays.fill(charToIndex, -1);

        int start = 0, end = 0, max = 0;
        int len = s.length();
        char[] charArr = s.toCharArray();

        for (; end < len; end++) {

            if (charToIndex[charArr[end]]!=-1) {
                /*
                will cause more time complexity
                int index = map.get(charArr[end]);
                for (; start <= index; start++) {
                    map.remove(charArr[start]);
                }
                */
                //"abba"
                start = Math.max(start, charToIndex[charArr[end]]+1);
                //start should not go back
                //we can't do start = map.get(charArr[end])+1
            }
            charToIndex[charArr[end]] = end;
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
```