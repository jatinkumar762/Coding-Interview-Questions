https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

#### Approach-1 Using HashMap

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
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

#### Approach-2 Using Hashing

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