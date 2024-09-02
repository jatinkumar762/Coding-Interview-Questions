
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