
#### Brute Force Method

* will replace characters from highFrequency character in current substring 
* bcz this will take less changes, at most we can do k changes for max substring

Ex: "AABABBA", k = 1

will prefer changing $B -> A$

* this method, trying to generate every substring and find max len
* its based on simple formula ->
  - no of changes required = len of current substring - max freq character


```java
class Solution {
    public int characterReplacement(String s, int k) {

        int len = s.length();
        int maxLen = 0;

        //other characters are replaced by max freq character
        //bcz this will take less changes
        // ((j-i+1) - maxFreq) <= 2
        // maxLen = ((j-i+1) - maxFreq)

        int[] freq;
        char[] charArr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            int maxFreq = 0;
            //s consists of only uppercase English letters.
            freq = new int[26];
            for (int j = i; j < len; j++) {
                freq[charArr[j]-'A']++;
                maxFreq = Math.max(freq[charArr[j]-'A'], maxFreq);

                if((j-i+1 - maxFreq) <= k){
                    maxLen = Math.max(j-i+1, maxLen);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
```

**Time Complexity** -> $O(N^2)$

#### Sliding Window Approach

```java
class Solution {
    public int characterReplacement(String s, int k) {

        int len = s.length();
        int maxLen = 0;

        // other characters are replaced by max freq character
        // bcz this will take less changes
        // ((j-i+1) - maxFreq) <= 2
        // maxLen = ((j-i+1) - maxFreq)

        int[] freq = new int[26];
        char[] charArr = s.toCharArray();

        int left = 0, right = 0, maxFreq = 0;

        for (; right < len; right++) {

            freq[charArr[right] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[charArr[right] - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[charArr[left] - 'A']--;

                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
```

**Time Complexity** -> $O(N+N)*26$

#### Optimization of above solution

* we want to maximize maxLen
* suppose if we find maxLen is 3, then next can be 4, 5, etc....
* will update left pointer only if ((len - maxFreq) > k) -> means both right and left are increasing by 1 -> same window size
* if < k, then only right pointer will increase, to maximize len

```java

```